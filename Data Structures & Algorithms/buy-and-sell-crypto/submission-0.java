class Solution {

    public int maxProfit(int[] arr) {
    int mx=0;
    for( int i=0; i<arr.length-1; i++){
        for( int j=i+1; j<arr.length; j++){
         int curr=arr[j]-arr[i];
            mx=Math.max(mx,curr);
        }
    }

       return mx; 
    }
}
