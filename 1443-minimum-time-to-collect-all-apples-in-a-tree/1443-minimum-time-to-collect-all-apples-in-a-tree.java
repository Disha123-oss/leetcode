class Solution {
    public int min(int src, int parent, ArrayList<Integer>[] graph, List<Boolean> hasApple){
        int total = 0;
        for(int nbr : graph[src]){
            if(nbr==parent)
                continue;
            total += min(nbr,src,graph,hasApple);
        }
        if(src!=0 && (hasApple.get(src)==true || total>0))
           total+=2;
        return total;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
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
        return min(0,0,graph,hasApple);
    }
}