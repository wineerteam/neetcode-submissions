class Solution {
             
    public boolean checkValidString(String s) {
         Boolean dp[][]=new Boolean[101][101];
        return solve(0,0,s,dp);
    }
    boolean solve(int i,int open ,String s,Boolean dp[][]){
        if( i == s.length())
        return (open==0);
         
         boolean isValid = false;

        if( dp[i][open] != null) return dp[i][open];
       
        // first handle "char == "*" three possible
        if( s.charAt(i) == '*'){
            // 1.case take replace as '('
            isValid |=solve(i+1,open+1,s,dp);
            
            //2. caes take replace by ')'
            if(open > 0)
            isValid |=solve(i+1,open-1,s,dp);

            // 3.case no replace as empty
            isValid |=solve(i+1,open,s,dp);
        
        } 
         // open bracket 

        else if( s.charAt(i) == '(')
              isValid |=solve(i+1,open+1,s,dp);
        else if( s.charAt(i) == ')'){
             if( open>0)
              isValid |=solve(i+1,open-1,s,dp); }

        return dp[i][open]=isValid;
        
    }
}