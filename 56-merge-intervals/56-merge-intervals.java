class Pair{
    int arval, dep;
    Pair(int arval, int dep){
        this.arval = arval;
        this.dep = dep;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(int[] num1, int[] num2) -> (Integer.compare(num1[0],num2[0])));
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(st.size()>0 && st.peek().dep>=intervals[i][0]){
                if(st.peek().dep<intervals[i][1]){
                    Pair nn = st.pop();
                    st.push(new Pair(nn.arval,intervals[i][1]));
                }
            }
            else
                st.push(new Pair(intervals[i][0],intervals[i][1]));
        }
        int[][] ans = new int[st.size()][2];
        int i = st.size()-1;
        while(st.size()>0){
            Pair nn = st.pop();
            ans[i][0] = nn.arval;
            ans[i][1] = nn.dep;
            i--;
        }
        return ans;
    }
}