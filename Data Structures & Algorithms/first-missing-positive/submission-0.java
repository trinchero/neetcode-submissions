class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            int val = nums[i];
            if(val>0&&val<=nums.length&&val!=nums[val-1]){
                int tmp = nums[val-1];
                nums[val-1]=val;
                nums[i]=tmp;
            } else {
                i++;
            }
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]!= j+1){
                return j+1;
            }
        }
        return nums.length+1;
    }
}