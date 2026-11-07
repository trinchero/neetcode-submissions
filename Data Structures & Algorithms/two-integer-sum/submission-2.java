class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int j=0;j<nums.length;j++){
            int val=target-nums[j];
            int k=map.getOrDefault(val, -1);
            if(k!=-1&&k!=j){
                
                return new int[]{j,k};
            }
        }
        return null;
    }
}
