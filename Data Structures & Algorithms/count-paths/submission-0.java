class Solution {
    public int uniquePaths(int m, int n) {
        // use dp memoization
        int dp [][]=new int [101][101];
        for( int i=0; i<dp.length; i++){
            Arrays.fill( dp[i], -1);
        }
        return solve( m,n,0,0,dp);
        
    }
    int solve( int m, int n, int i, int j,int dp[][]){
        // Hit target 
        if( i == m-1 && j == n-1) return 1;

        // in valide path 
        if( i>=m || i<0 || j>=n || j<0)
        return 0;
        
        // check if already calculate then return it 
        if( dp[i][j] != -1) return dp[i][j];

        // int right = solve( m,n,i,j+1,dp);  // possible valid path
        // int down  = solve( m,n,i+1,j,dp);  // possible valid path

        return dp[i][j] = solve( m,n,i,j+1,dp)+solve( m,n,i+1,j,dp);
    }
}
