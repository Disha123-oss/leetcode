class Pair{
    int start=0,finish=0;
    Pair(int start, int finish){
        this.start = start;
        this.finish = finish;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++){
            arr[i] = new Pair(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(arr,(o1,o2)->(o1.start-o2.start));
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(st.size()>0){
                if(st.peek().finish>=arr[i].start && st.peek().finish<arr[i].finish){
                    st.peek().finish = arr[i].finish;
                }
                else if(st.peek().finish<arr[i].start){
                    st.push(arr[i]);
                }
            }
            else
                st.push(arr[i]);
        }
        n = st.size();
        int[][] res = new int[n][2];
        for(int i=n-1;i>=0;i--){
            Pair p = st.pop();
            res[i][0] = p.start;
            res[i][1] = p.finish;
        }
        return res;
    }
}