class Solution {
    public boolean isMatch(String s, String p) {
       Boolean dp [][] = new Boolean [21][21];
       
       for( int i=0; i<dp.length; i++){
        Arrays.fill( dp[i],false);
       }
        return solve(s,p,0,0,dp);
        
    }
    boolean solve( String s, String p, int i, int j,Boolean dp[][] ){
         // base case pattern end
        // jab pattern khatam ho tabhi stirng bhi khatam ho then reuturn true
        if( j==p.length()){
            return i==s.length();
        }         
        
        if( dp[i][j] != false) return dp[i][j];
        boolean first_match = ( i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'));
         // if  get * then we have two option or take or non -take
         if( j+1 < p.length() && p.charAt(j+1) == '*'){
            
            // non-take
            boolean non_take= solve( s,p,i,j+2,dp);
            boolean     take= first_match && solve(s,p,i+1,j,dp);
            return dp[i][j] = (take || non_take);
         }

         else{
                // not have * symbol
                // character equal ho then 
                if(first_match )
                return dp[i][j]=solve(s,p,i+1,j+1,dp);

                else  // not match character 
                    return false;
         }

    }
}
