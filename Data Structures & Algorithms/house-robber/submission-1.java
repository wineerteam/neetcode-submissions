class Solution {
static int Robbery(int index, int [] nums,int []dp){

    if( index == 0)
    return nums[index];

    if( index == 1)
    return Math.max(nums[1],nums[0]);

    if( dp[index] != -1)
    return dp[index];

    return dp[index]=Math.max(nums[index]+Robbery(index-2,nums,dp),Robbery(index-1,nums,dp));
}
    public int rob(int[] nums) {
        int n=nums.length;
        int dp []=new int[n];
        Arrays.fill(dp,-1);
        return Robbery(n-1,nums,dp);
        
    }
}
