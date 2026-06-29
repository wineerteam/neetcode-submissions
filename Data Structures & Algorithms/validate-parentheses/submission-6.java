class Solution {
    public boolean isValid(String s) {
      Stack<Character>st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(') st.push(')');
        else if(ch=='{')st.push('}');
        else if(ch=='[')st.push(']');
        else{
            // then difinatly closing braket h or stack empty hoga
            if( st.isEmpty() || ch != st.peek()) return false;
            else {
                // match kr gya top and char so pop kro
                st.pop();
            }
        }
        }
        return (st.isEmpty()) ;
    }
}