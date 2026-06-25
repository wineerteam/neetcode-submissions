class Solution {
    public int maxSubArray(int[] nums) {

        // 1. brute forces  Tc--o(n^3)
        // 2. we can better solution Tc--o(n^2)
        // 3. we can optimize this problem  Tc--o(n)
        // 4. Let me Explain it... 

        int maxi=Integer.MIN_VALUE;
        
        for( int i=0; i<nums.length; i++){
            for( int j=i; j<nums.length; j++){
                int sum =0;
                for( int k=i; k<=j; k++){
                    sum+=nums[k];

                }
                maxi=Math.max(maxi, sum);
            }
        }
        return maxi;
    }
}
