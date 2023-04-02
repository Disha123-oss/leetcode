class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] arr = new int[n];
        for(List<Integer> edge : edges){
            arr[edge.get(1)] = 1;
        }
        List<Integer> al = new ArrayList<>(); 
        for(int i=0;i<n;i++){
           if(arr[i]==0)
               al.add(i);
        }
        return al;
    }
}