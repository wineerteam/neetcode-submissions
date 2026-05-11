class Solution {
    public int maxProfit(int[] arr) {

        int minprice=Integer.MAX_VALUE;
        int maxprofit=0;
        int ans=0;

        for( int i=0; i<arr.length; i++ ){
            minprice=Math.min(arr[i],minprice);
            maxprofit=Math.max(maxprofit,arr[i]-minprice);

        }
        return maxprofit;
    }
}
// Tow pointers  Tc (N) and Sc (1)
