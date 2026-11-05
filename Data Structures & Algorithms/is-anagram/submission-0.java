class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null || s.isEmpty() || t.isEmpty() || s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int val=map.getOrDefault(c, 0)+1;
            map.put(c,val);
        }
        List<Integer> list=new ArrayList<>(map.values());
        System.out.println(list); 
        for(int j=0;j<t.length();j++){
            char c=t.charAt(j);
            if(!map.containsKey(c))return false;
            int val=map.get(c);
            if(val<=0)return false;
            map.put(c, val-1);
        }
        list=new ArrayList<>(map.values());
        System.out.println(list); 
        for(int i:list){
            if(i!=0)return false;
        }
        return true;
    }
}
