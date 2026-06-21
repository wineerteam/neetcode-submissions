class Solution {
    
    public int getSum(int a, int b) {
        // sum of two numbers
        
        // repeate until b ==0 
        while( b!=0){
            int temp=(a&b)<<1;
            a=a^b;
            b=temp;
        }
        return a;
    }
}
