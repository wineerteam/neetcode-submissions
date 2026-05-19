
class Solution {
    public int rob(int[] nums) {
        
        int n=nums.length;

        if( n == 1)
        return nums[0];

        if( n == 2)
        return Math.max(nums[0],nums[1]);

        int curr1, prev2=nums[0], prev = Math.max(nums[0], nums[1]);
        curr1=prev;

        for( int i=2; i<n-1; i++){
            curr1 = Math.max(nums[i]+prev2, prev);
            prev2=prev;
            prev=curr1;
        }

       int curr2=0;
        prev2=nums[1];
        prev = Math.max(nums[1], nums[2]);
        curr2=prev;

         for( int i=3; i<n; i++){
            curr2 = Math.max(nums[i]+prev2, prev);
            prev2=prev;
            prev=curr2;
        }

        return Math.max(curr1, curr2);

        
    }
}