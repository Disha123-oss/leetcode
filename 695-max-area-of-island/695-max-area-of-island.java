class Solution {
    int max=0;
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    public void bfs(int i, int j, int[][] grid, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j]=true;
        int count=1;
        
        while(q.size()>0){
            int size = q.size();
            for(int l=0;l<size;l++){
                int[] temp = q.remove();
                for(int m=0;m<4;m++){
                     int r = temp[0]+dr[m];
                     int c = temp[1]+dc[m];
                     if(r<0 || r>=grid.length || c<0 || c>=grid[0].length)  continue;
                     if(visited[r][c]==false && grid[r][c]==1){
                         q.add(new int[]{r,c});
                         visited[r][c]=true;
                         count++;
                         max=Math.max(max,count);
                     }
                }
            }
        }
        max=Math.max(max,count);
    }
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==false && grid[i][j]==1)
                    bfs(i,j,grid,visited);
            }
        }
        return max;
    }
}