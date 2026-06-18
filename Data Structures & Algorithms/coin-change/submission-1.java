class Solution {
    public int coinChange(int[] arr, int t) {
        int n = arr.length;
        int ans= solve( arr, n-1,t);
        if( ans >= 1e9) return -1;
        return ans;
    }

    int solve( int arr [], int ind, int t){
        if( ind == 0){
            if( t % arr[0] == 0) return t/arr[0];
            return (int)1e9;
        }
        
         int non_take = 0 + solve( arr, ind-1,t);

         int take = Integer.MAX_VALUE;
         
         if( arr[ind]  <= t){
            take = 1+solve(arr,ind,t-arr[ind]);
         }

         return Math.min(non_take,take);
    }
}
