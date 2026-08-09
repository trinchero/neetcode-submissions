class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] p:prerequisites){
            List<Integer> list = map.getOrDefault(p[1], new ArrayList<>());
            list.add(p[0]);
            map.put(p[1], list);
        }
        List<Integer> res = new ArrayList<>();
        int[] state=new int[numCourses];//0 not visited, 1 visiting, 2 visited
        for(int course = 0; course < numCourses; course++){
            if(hasCycle(course, map, state, res))return new int[0];
        }
        Collections.reverse(res);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private boolean hasCycle(int course, Map<Integer,List<Integer>> map, int[]state, 
    List<Integer> res){
        if(state[course]==1){return true;}
        if(state[course]==2){return false;}
        state[course]=1;
        List<Integer> req = map.getOrDefault(course, new ArrayList<>());
        for(int i:req){
            if(hasCycle(i,map,state,res))return true;
        }
        state[course]=2;
        res.add(course);
        return false;
    }
}
