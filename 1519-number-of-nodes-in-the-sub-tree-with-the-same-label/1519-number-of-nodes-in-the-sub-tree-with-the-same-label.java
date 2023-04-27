class Solution {
    int[] res;
    public int[] compute(int src, int parent, ArrayList<Integer>[] graph, String labels){
        int[] count = new int[26];
        for(int nbr : graph[src]){
            if(nbr==parent)
                continue;
            int[] ans = compute(nbr,src,graph,labels);
            for(int i=0;i<26;i++){
                count[i]+=ans[i];
            }
        }
        char ch = labels.charAt(src);
        count[ch-'a']++;
        res[src] = count[ch-'a'];
        return count;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
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
        res = new int[n];
        compute(0,-1,graph,labels);
        return res;
    }
}