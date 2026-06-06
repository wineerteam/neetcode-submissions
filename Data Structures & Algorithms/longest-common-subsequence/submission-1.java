class Solution {
  
    int dp [][] = new int[1001][1001];
    public int longestCommonSubsequence(String s1, String s2) {
        // dp=new int [1001][];
        for( int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
      return   solve (s1,s2,0,0);
        
    }
    public int solve( String s1, String s2, int i, int j){
        if( i>=s1.length() || j>=s2.length() )
        return 0;
        if( dp[i][j] != -1)
        return dp[i][j];
        
        if( s1.charAt(i) == s2.charAt(j)){
            return dp[i][j]= 1+solve(s1,s2,i+1,j+1);
        }
        
            // not match then we have two choice both take at a time jo best h. wo usko return krwana h 
            return dp[i][j]= Math.max(solve(s1,s2,i,j+1),solve(s1,s2,i+1,j));
        
    }
}
