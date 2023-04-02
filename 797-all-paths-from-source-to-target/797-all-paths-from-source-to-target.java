class Solution {
    void dfs(int src, int des, int graph[][], List<Integer> al, List<List<Integer>> res){
	   if(src==des){
			res.add(new ArrayList<>(al));
			return;
		}
		for(int ele : graph[src]){
            al.add(ele);
			dfs(ele,des,graph,al,res);
            al.remove(al.size()-1);
		}
	}
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>(); 
	    List<Integer> al = new ArrayList<>(); 
        al.add(0);
		dfs(0,graph.length-1,graph,al,res);
        return res;
    }
}