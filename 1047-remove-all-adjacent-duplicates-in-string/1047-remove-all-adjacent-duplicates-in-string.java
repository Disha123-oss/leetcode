class Solution {
    public String removeDuplicates(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<ch.length;i++){
            if(st.size()==0)
                st.push(ch[i]);
            else if(st.peek()!=ch[i])
                st.push(ch[i]);
            else
                st.pop();
        }
        String str="";
        while(st.size()>0){
            str+=st.peek();
            st.pop();
        }
        s="";
        for(int i=str.length()-1;i>=0;i--){
            s+=str.charAt(i);
        }
        return s;
    }
}