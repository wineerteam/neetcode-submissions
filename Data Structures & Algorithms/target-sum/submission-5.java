class Solution {
    
    Map <String , Integer> map=new HashMap<>();

    public int findTargetSumWays(int[] arr, int target) {
        
        return solve( arr, 0,0,target);
        
    }
    int solve( int arr[], int i ,int sum, int target){
        if( i== arr.length){
            if( sum == target )
            return 1;
            else 
            return 0;
        }
        String key= i+"_"+sum;
        if( map.containsKey(key))
        return map.get(key);
          
          // we have two chooice add or minus 
          int add  = solve( arr, i+1, sum+arr[i], target);
          int minus= solve( arr, i+1, sum-arr[i], target);
          map.put(key, add+minus);
          return map.get(key);
    }
}

// 1 use simple recursion becasue we have chooce 
// 2.use hash map becaus index range to -ve and hamara code ft jaey ga
// 3.use Memoization then shit sum value -ve range to +ve nhi to code ft jaey ga
