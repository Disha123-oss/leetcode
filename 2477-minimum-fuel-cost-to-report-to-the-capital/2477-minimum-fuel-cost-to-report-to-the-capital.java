class Solution {
    long fuel = 0;
    int seats = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            int a = roads[i][0];
            int b = roads[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        this.seats = seats;
        dfs(graph,0,-1);
        return fuel;
    }
    public int dfs(ArrayList<Integer>[] graph, int curr, int prev){
        int people=1;
        for(int ele : graph[curr]){
            if(ele==prev)
                continue;
            people+=dfs(graph,ele,curr);
        }
        if(curr!=0){
            fuel+=(long)(Math.ceil((double)people/this.seats));
        }
        return people;
    }
}