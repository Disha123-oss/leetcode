class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.size()>0 && s.charAt(i)=='*')
                st.pop();
            else
                st.push(s.charAt(i));
        }
        StringBuilder str = new StringBuilder();
        while(st.size()>0){
           str.append(st.pop());
        }
        str.reverse();
        return str.toString();
    }
}