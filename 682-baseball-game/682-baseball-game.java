class Solution {
    public boolean isNumeric(String s){
        boolean num=true;
        try{
            int d = Integer.parseInt(s);
           }
        catch(Exception e){
            num=false;
        }
        return num;
    }
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<operations.length;i++){
            if(isNumeric(operations[i]))
                st.push(Integer.parseInt(operations[i]));
            else if((operations[i]).equals("C") && st.size()>0)
                st.pop();
            else if((operations[i]).equals("D") && st.size()>0)
                st.push(st.peek()*2);
            else{
                if(st.size()>1){
                    int a = st.peek();
                    st.pop();
                    int sum = st.peek()+a;
                    st.push(a);
                    st.push(sum);
                }
            }
        }
        int sum=0;
        while(st.size()>0){
            sum+=st.peek();
            st.pop();
        }
        return sum;
    }
}