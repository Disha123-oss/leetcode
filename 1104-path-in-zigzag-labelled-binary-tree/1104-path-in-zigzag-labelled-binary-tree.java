class Solution {
    public List<Integer> pathInZigZagTree(int n) {
        List<Integer> list = new ArrayList<>();
        int start=1;
        int end=0;
        int level=0;
        while(end<n){
            end+=start;
            start*=2;
            level++;
        }
        start/=2;
        level--;
        
        while(n!=1){
            list.add(n);
            int comp = start+end-n;
            int parent = comp/2;
            n=parent;
            end=end-start;
            start/=2;
        }
        list.add(1);
        Collections.reverse(list);
        return list;
    }
}