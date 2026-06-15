class Solution {
    
   

    public int findTargetSumWays(int[] arr, int target) {
         int n=arr.length;
         int dp[][]=new int [n][2001];
         
         for( int i=0; i<n; i++){
            Arrays.fill( dp[i],-1);
         }
        return solve( arr, 0,0,target,dp);
        
    }
    int solve( int arr[], int i ,int sum, int target,int dp[][]){
        if( i== arr.length){
            if( sum == target )
                return 1;
            else 
                return 0;
        }

       if( dp[i][sum+1000] != -1){
        return dp[i][sum+1000];
       }
          
          // we have two chooice add or minus 
          int add  = solve( arr, i+1, sum+arr[i], target,dp);
          int minus= solve( arr, i+1, sum-arr[i], target,dp);
         
         return dp[i][sum+1000]=add+minus;
    }
}

// 1 use simple recursion becasue we have chooce 
// 2.use hash map becaus index range to -ve and hamara code ft jaey ga
// 3.use Memoization then shit sum value -ve range to +ve nhi to code ft jaey ga
