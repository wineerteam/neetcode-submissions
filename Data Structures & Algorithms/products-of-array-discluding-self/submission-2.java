class Solution {

    public int[] productExceptSelf(int[] nums) {

        int product = 1;
        int zeroCount = 0;

        int[] ans = new int[nums.length];

        for (int num : nums) {

            if (num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }
        for (int i = 0; i < nums.length; i++) {

            if (zeroCount > 1) {
                ans[i] = 0;
            }
            else if (zeroCount == 1) {

                if (nums[i] == 0) {
                    ans[i] = product;
                } else {
                    ans[i] = 0;
                }
            }
            else {
                ans[i] = product / nums[i];
            }
        }

        return ans;
    }
}