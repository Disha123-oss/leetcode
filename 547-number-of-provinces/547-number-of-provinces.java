class Solution {
    public void dfs(int src, ArrayList<Integer>[] graph, boolean[] visited){
        visited[src]=true;
        for(int ele : graph[src]){
            if(visited[ele]==false){
                visited[ele]=true;   //making adjacent components true
                dfs(ele,graph,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)  continue;
                if(isConnected[i][j]==1)
                    graph[i].add(j);
            }
        }
        boolean[] visited = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                dfs(i,graph,visited);
                count++;    //counting disconnected components
            }
        }
        return count;
    }
}