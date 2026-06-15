class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length(); 
        int m = s2.length();
        int dp[][]= new int[101][101];

        for( int i=0; i<dp.length; i++){
            Arrays.fill( dp[i],-1);
        }

        return solve( s1,s2,n-1,m-1,dp);
    }
    int solve( String s1, String s2, int n, int m,int dp[][]){
        // 
        if ( n < 0) return m + 1;
        if ( m < 0) return n + 1;
        
        if ( dp[n][m] != -1){
            return dp[n][m];
        }
        if(s1.charAt(n) == s2.charAt(m) )
        return dp[n][m]=solve( s1,s2,n-1,m-1,dp);
        else{
            int insert=solve( s1,s2,n,m-1,dp);
            int delete=solve( s1,s2,n-1,m,dp);
            int replac=solve( s1,s2,n-1,m-1,dp);

            return dp[n][m]=1+Math.min(insert,Math.min(delete,replac));
        }
    }
}
