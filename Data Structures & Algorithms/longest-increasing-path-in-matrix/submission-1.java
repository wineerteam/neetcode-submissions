class Solution {
    int row=0;
    int col=0; 
    public int longestIncreasingPath(int[][] arr) {
     // golobal varibale inilize 
     row = arr.length;
     col = arr[0].length;
     
     // overlapping problem used dp declaere and inilize 
     int dp[][] = new int [row][col];

     for( int i=0; i<dp.length; i++){
        Arrays.fill( dp[i],-1);
     }
      
    //   store ans 
     int ans =0; 
     
     // use optimized dfs 
     for( int i=0; i<row; i++){
        for ( int j=0; j<col; j++){

            ans =Math.max ( ans, solve( arr,dp,i,j));
        }
     }
        return ans ;
        
    }
    int solve( int arr[][] , int [][] dp,int i, int j){

       // check if already calculate then retrun direct 
       if( dp[i][j] != -1) return dp[i][j];

    //    store the value 
       int top=0,bottom=0,left=0,right=0;
       // move all diretion top ,bottom, left ,right about  (i,j)

       // top (i-1,j)
       if( valid(arr,i-1,j) && arr[i-1][j] > arr[i][j]){
          top= solve( arr,dp,i-1,j);
       }
       // bottom
       if( valid(arr,i+1,j) && arr[i+1][j] > arr[i][j]){
        bottom = solve( arr,dp,i+1,j);
       }
       // left 
       if( valid(arr,i,j-1) && arr[i][j-1] > arr[i][j]){
        left=solve(arr,dp,i,j-1);
       }
       // right 
       if( valid(arr,i,j+1) && arr[i][j+1] > arr[i][j]){
        right= solve( arr,dp,i,j+1);
       }

       // mind max between (top,bottom,left,rigth)
       return dp[i][j]= 1+ Math.max(top,Math.max(bottom,Math.max(left,right)));

    }
    boolean valid(int arr[][],int i,int j){
        // check if out of boudery or out of length then return false
        if( i < 0 || j < 0 || i > row-1 || j > col-1)
            return false;
            return true;
        
    }
}
