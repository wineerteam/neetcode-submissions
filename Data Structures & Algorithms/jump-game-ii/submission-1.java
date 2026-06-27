class Solution {
    int dp[][]=new int [1001][1001];
    public int jump(int[] nums) {
        for( int i=0; i<dp.length; i++)
    {
        Arrays.fill(dp[i],-1);
    }
        return solve( nums,0,0);
    }
    int solve( int arr[], int ind, int jump){
        if( ind>=arr.length-1) return jump;

        if( dp[ind][jump] != -1) return dp[ind][jump];
        // min 
        int min=Integer.MAX_VALUE;
        for( int i=1; i<=arr[ind]; i++){
          min=Math.min(min,solve(arr,ind+i,jump+1));
        }
        return dp[ind][jump]= min;
    }
}
