class Solution {
    public int reach(int src, int parent, ArrayList<Integer>[] graph, Set<Integer> hs){
        int count=1;
        for(int ele : graph[src]){
            if(hs.contains(ele) || ele==parent)
                continue;
            count+=reach(ele,src,graph,hs);
        }
        return count;
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        Set<Integer> hs = new HashSet<>();
        for(int i=0;i<restricted.length;i++){
            hs.add(restricted[i]);
        }
        return reach(0,-1,graph,hs);
    }
}