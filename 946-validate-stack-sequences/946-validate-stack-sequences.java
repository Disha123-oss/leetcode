class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=0,j=0,n=pushed.length;
        Stack<Integer> st = new Stack<>();
        while(i<n || j<n){
            while(st.size()>0 && st.peek()==popped[j]){
                st.pop();
                j++;
            }
            if(i<n){
                st.push(pushed[i]);
                i++;
            }
            else if(st.size()>0 && st.peek()!=popped[j])
                break;
        }
        if(st.size()>0)
            return false;
        return true;
    }
}