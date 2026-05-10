class Solution {
    public int trap(int[] arr) {
        int n=arr.length;

        int [] lm=new int[n];
        int [] rm=new int[n];
        int [] ans=new int[n];
            lm[0]=0;
        for( int i=1; i<n; i++){
            // int mx=0;
            lm[i]=Math.max(lm[i-1],arr[i-1]);
        }
             rm[n-1]=0;
        for( int i=n-2; i>=0; i--){

            rm[i]=Math.max(arr[i+1],rm[i+1]);
        }

        for( int i=0; i<n; i++){
            int temp=Math.min(lm[i],rm[i]);
            int diff=temp-arr[i];
            if( diff >0 ){
                ans[i]=diff;
            }
            else{
                ans[i]=0;
            }
        }

        int fans=0;
        for( int num: ans){
            fans +=num;
        }
        return fans;
    }
}
