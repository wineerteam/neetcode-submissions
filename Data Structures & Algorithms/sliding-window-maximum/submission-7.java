class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // k-1 ko matain kro deque me then 
        int n=nums.length;
        Deque<Integer> d=new LinkedList<>();
        int ans []=new int [n-k+1];

        for( int i=0; i<k-1; i++){
                
                // jab khali h dequeu then add 
                if( d.isEmpty()){
                   d.addLast(i);
                }
                 
                // whne jab already ho to the use cndition if currnt elemnt is grate then then remvoe it or maint dec order in de quej
                else {
                        while( !d.isEmpty() && nums[i] > nums[d.peekLast()]){
                                d.removeLast();
                        }
                        d.addLast(i);
                }
        }
        


        // ab krete h windo statr okey bro k-1 to n
        for( int i=k-1; i<n; i++){
                // 1.pop smaller elemnt 
                while( !d.isEmpty() && nums[i] > nums[d.peekLast()]){
                        d.removeLast();

                }
                d.addLast(i);

                  // if out of window then remve it form fornt
                  if( d.peekFirst() <= i-k){
                        d.removeFirst();
                  }
                
                ans[i-k+1]=nums[d.peekFirst()];


        }
        return ans;
    }
}
