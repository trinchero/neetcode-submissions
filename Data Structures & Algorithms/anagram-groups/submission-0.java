class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null)throw new IllegalArgumentException("Test");
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            //convert stringa in array di char, poi sort e store in mappa
            char[] tmp=s.toCharArray();
            Arrays.sort(tmp);
            String ordered=new String(tmp);
            List<String> list = map.getOrDefault(ordered, new ArrayList<>());
            list.add(s);
            map.put(ordered, list);
        }
        List<List<String>> result=new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}
