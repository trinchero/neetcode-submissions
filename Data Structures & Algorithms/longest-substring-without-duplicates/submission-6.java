class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left=0;
        int max=0;
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right); 
            if(map.containsKey(c)){
                //se e gia presente devi spostare left: 
                //nel caso siano due lettere vicine devi fare left+1,ma se sono lettere lontane es
                //abba bisogna prendere left
                left=Math.max(left, map.get(c)+1);
            }
            map.put(c,right);
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
