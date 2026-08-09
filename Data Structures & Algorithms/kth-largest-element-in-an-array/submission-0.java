class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0) throw new IllegalArgumentException("Wrong input");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n:nums){
            pq.offer(n);
            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}
