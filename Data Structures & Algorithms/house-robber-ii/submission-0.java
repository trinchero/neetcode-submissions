class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(
            rob(nums, 0, nums.length-2),
            rob(nums, 1, nums.length-1)
        );
    }

    private int rob(int[] nums, int start, int end) {
        int prev1=0;
        int prev2=0;
        while(start<=end) {
            int current = Math.max(prev1, prev2+nums[start]);
            prev2=prev1;
            prev1=current;
            start++;
        }
        return prev1;
    }
}
