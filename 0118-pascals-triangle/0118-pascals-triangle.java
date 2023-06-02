class Solution {
    public int ncr(int n, int r){
        int ans=1;
        for(int i=0;i<r;i++){
            ans = ans * (n-i);
            ans/=(i+1);
        }
        return ans;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> al = new ArrayList<>();
            for(int j=1;j<=i;j++){
                al.add(ncr(i-1,j-1));
            }
            list.add(al);
        }
        return list;
    }
}