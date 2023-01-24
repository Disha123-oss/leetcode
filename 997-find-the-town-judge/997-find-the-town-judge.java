class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] graph = new int[2][n+1];
        for(int[] arr : trust){
            int a = arr[0];
            int b = arr[1];
            graph[0][a]++;
            graph[1][b]++;
        }
        for(int i=1;i<=n;i++){
            if(graph[1][i]==n-1 && graph[0][i]==0){
                return i;
            }
        }
        return -1;
    }
}