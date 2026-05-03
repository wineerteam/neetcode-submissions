class Solution {
    public boolean isPalindrome(String s) {

        
        String result = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int j=result.length()-1;
        int i=0;
        while( i < j){
        
           if( result.charAt(i) != result.charAt(j))
           return false;
           j--;
           i++;
        }
             return true;
    }
}
