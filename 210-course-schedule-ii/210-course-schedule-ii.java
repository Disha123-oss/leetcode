class Solution {
    ArrayList<Integer> al = new ArrayList<>();
	public void dfs(int src, boolean visited[], ArrayList<Integer>[] graph){
		visited[src]=true;
		for(int ele : graph[src]){
			if(visited[ele]==false){
				dfs(ele,visited,graph);
				al.add(ele);
			}
		}
	}
	public boolean dfs_cycle(int src, boolean[] visited, boolean[] path, ArrayList<Integer>[] graph){
		visited[src]=true;
		path[src]=true;
		for(int ele : graph[src]){
			if(visited[ele]==false){
				boolean ans=dfs_cycle(ele,visited,path,graph);
				if(ans==true)  return true;
			}
			else if(visited[ele]==true && path[ele]==true)
				return true;
		}
		path[src]=false;
		return false;
	}
	public boolean iscycle(int n, ArrayList<Integer>[] graph){
		boolean visited[] = new boolean[n];
		boolean path[] = new boolean[n];
		for(int i=0;i<n;i++){
			if(visited[i]==false){
				boolean check=dfs_cycle(i,visited,path,graph);
				if(check==true)
					return true;
			}
		}
		return false;
	}
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[n];
		for(int i=0;i<n;i++){
			graph[i] = new ArrayList<>();
		}
		for(int[] edge : prerequisites){
			int u = edge[0];
			int v = edge[1];
			graph[u].add(v);
		}
		boolean iscycle = iscycle(n,graph);
		if(iscycle==true)  return new int[]{};
		boolean[] visited = new boolean[n];
		for(int i=0;i<n;i++){
			if(visited[i]==false){
				dfs(i,visited,graph);
				al.add(i);
			}
		}
		int[] arr = new int[n];
		for(int i=0;i<al.size();i++){
			arr[i]=al.get(i);
		}
		return arr;
    }
}