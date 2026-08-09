class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null||nums.length==0||k==0) {
            throw new IllegalArgumentException("Wrong Input");
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:nums){
            int val=map.getOrDefault(i, 0);
            map.put(i, val+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (x,y) -> Integer.compare(map.get(x), map.get(y))
        );
        
        for(int n: map.keySet()){
            pq.offer(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int l=0;
        int[] res = new int[pq.size()];
        while(pq.size()!=0){
            res[l++]=pq.poll();
        }
        return res;
    }
}
