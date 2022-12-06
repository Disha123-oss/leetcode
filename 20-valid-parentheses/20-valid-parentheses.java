class Solution {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<ch.length;i++){
            if(st.size()==0)
                st.push(ch[i]);
            else if(ch[i]==')' && st.peek()=='(')
                st.pop();
            else if(ch[i]=='}' && st.peek()=='{')
                st.pop();
            else if(ch[i]==']' && st.peek()=='[')
                st.pop();
            else
                st.push(ch[i]);
        }
        if(st.size()==0)
            return true;
        else
            return false;
    }
}