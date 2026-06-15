class Solution {
    public int findTargetSumWays(int[] arr, int t){
        return solve( arr, t,0,0);        
    }
    int solve( int arr[],int t,int way,int i){
        if( i == arr.length){
          if( way == t ) return 1;
          else 
               return 0;
        }
        
        int take_sum = solve( arr,t,way+arr[i],i+1);
        int take_diff= solve( arr,t,way-arr[i],i+1);
     return take_sum+take_diff;

    }
}
