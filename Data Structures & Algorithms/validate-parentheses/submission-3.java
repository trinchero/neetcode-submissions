class Solution {
    public boolean isValid(String s) {
        if(s==null||s.isEmpty())return false;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{'){stack.push(c);}
            else{
                if(stack.isEmpty())return false;
                char k=stack.pop();
                if(k=='('&&c!=')'){return false;}
                if(k=='['&&c!=']'){return false;}
                if(k=='{'&&c!='}'){return false;}
            }
        }
        if(stack.isEmpty())return true;
        return false;
    }
}
