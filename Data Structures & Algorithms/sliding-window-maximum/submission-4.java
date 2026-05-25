class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

// 1. enter the k-1
// 2. then k-1 to n 
// 3. ans
          int n=nums.length;

          int [] ans=new int[n-k+1];
          Deque<Integer> q=new LinkedList<>();
           
           for( int i=0; i<k-1; i++){

                   // when deueu is empty()
                   if( q.isEmpty()){
                        q.addLast(i);
                   }
                   else{
                        // when element present then maitain dec order with 
                        // pop used 
                        while( !q.isEmpty() && nums[i] > nums[q.peekLast()]){
                                  q.removeLast();
                        }
                                  q.addLast(i);
                   }

           }

           // 2. k-1 to n 
           int j=0;
           for( int i=k-1; i<n; i++){
                
                // pop back the smaller 
        while( !q.isEmpty() && nums[i] > nums[q.peekLast()]){
                q.removeLast();
        }
               q.add(i);

               // check out side the window then remvoe it
               if( q.peekFirst() <= i-k){
                q.removeFirst();
               }
           
               ans[i-k+1]=nums[q.peekFirst()];
           }
        return ans;
    }
}
