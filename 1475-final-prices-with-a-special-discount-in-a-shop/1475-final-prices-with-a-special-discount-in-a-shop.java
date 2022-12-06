class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            if(st.size()==0)
                st.push(i);
            else if(prices[i]<=prices[st.peek()]){
                while(st.size()>0 && prices[i]<=prices[st.peek()]){
                    ans[st.peek()]=prices[st.peek()]-prices[i];
                    st.pop();
                }
                st.push(i);
            }
            else
                st.push(i);
        }
        while(st.size()>0){
            ans[st.peek()]=prices[st.peek()];
            st.pop();
        }
        return ans;
    }
}