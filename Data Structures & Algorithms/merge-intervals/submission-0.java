class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null) throw new IllegalArgumentException("Wrong input");
        Arrays.sort(intervals,(x,y)->Integer.compare(x[0],y[0]));
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] current=intervals[i];
            if(current[0]<=prev[1]){
                prev[1]=Math.max(prev[1],current[1]);
            } else{
                res.add(prev);
                prev=current;
            }
        }
        res.add(prev);
        return res.toArray(new int[res.size()][]);
    }
}
