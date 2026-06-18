class Solution {
    public int coinChange(int[] arr, int t) {

        int n = arr.length;

        int dp[][]=new int [10+1][t+1];

        for( int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }

        int ans= solve( arr, n-1,t,dp);

        if( ans >= 1e9) return -1;
        return ans;
    }

    int solve( int arr [], int ind, int t,int dp[][]){
        if( ind == 0){
            if( t % arr[0] == 0) return t/arr[0];
            return (int)1e9;
        }
        
        // calculated value ko use kro 
        if(dp[ind][t] != -1 )return dp[ind][t];

         // non_take 
         int non_take = 0 + solve( arr, ind-1,t,dp);
         // take 
         int take = Integer.MAX_VALUE;
         
         
         if( arr[ind]  <= t){
            take = 1+solve(arr,ind,t-arr[ind],dp);
         }

         return dp[ind][t] = Math.min(non_take,take);
    }
}
