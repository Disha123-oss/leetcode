class Solution {
    public String removeOuterParentheses(String s) {
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        for(int i=0;i<str.length;i++){
            if(st.size()==0){
                al.add(i);
                st.push(str[i]);
            }
            else if(str[i]==')' && st.peek()=='('){
                st.pop();
                if(st.size()==0)
                    al.add(i);
            }
            else
                st.push(str[i]);
        }
        String ss="";
        for(int i=0;i<al.size();i+=2){
            ss+=s.substring(al.get(i)+1,al.get(i+1));
        }
        return ss;
    }
}