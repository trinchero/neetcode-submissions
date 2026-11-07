class Solution {
    public boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char c=Character.toLowerCase(s.charAt(i));
            if(Character.isLetterOrDigit(c)){
                stack.push(c);
            }
        }
        for(int j=0;j<s.length();j++){
            char c=Character.toLowerCase(s.charAt(j));
            if(Character.isLetterOrDigit(c)){
            char expectedChar=stack.pop();
            if(c!=expectedChar){
                return false;
            }
            }
        }
        if(stack.isEmpty())return true;
        return false;
    }
}
