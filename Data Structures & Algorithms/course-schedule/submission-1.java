class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] p:prerequisites){
            List<Integer> list = map.getOrDefault(p[1],new ArrayList<>());
            list.add(p[0]);
            map.put(p[1],list);
        }
        int[] state= new int[numCourses];
        for(int course:map.keySet()){
            /*
                0 not visited
                1 visting
                2 already visited
            */
            if(hasCycle(course, map, state)){
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int course, Map<Integer,List<Integer>> map, int[] state){
        if(state[course]==1) return true;
        if(state[course]==2) return false;
        state[course]=1;
        List<Integer> freq=map.getOrDefault(course, new ArrayList<>());
        for(int i=0; i<freq.size(); i++){
            if(hasCycle(freq.get(i), map, state)) return true;
        }
        state[course]=2;
        return false;
    }
}
