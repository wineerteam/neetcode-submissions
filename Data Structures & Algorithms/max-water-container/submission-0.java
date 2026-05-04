class Solution {
    public int maxArea(int[] arr) {
        int n=arr.length;
        int mx=0;
        int left=0;
        int right=n-1;

        while ( left<right){
           int width=right-left;
            int currentArea=Math.min(arr[left],arr[right])*width;
            mx=Math.max(mx,currentArea);
            if( arr[left] < arr[right])
            left++;
            else{
                right--;
            }
        }
        return mx;
    }
}
