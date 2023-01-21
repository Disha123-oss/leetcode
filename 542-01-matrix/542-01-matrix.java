class Solution {
    int[] dr = {-1,1,0,0};
	int[] dc = {0,0,-1,1};
    public int[][] updateMatrix(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]==0){
					q.add(new int[]{i,j});
					visited[i][j]=true;
				}
			}
		}
		int level=0;
		while(q.size()>0){
			int size = q.size();
			for(int i=0;i<size;i++){
				int[] temp = q.remove();
				int r = temp[0];
				int c = temp[1];
				grid[r][c]=level;
				for(int j=0;j<4;j++){
					int sr = r+dr[j];
					int sc = c+dc[j];
					if(sr<0||sc<0||sr>=grid.length||sc>=grid[0].length)  continue;
					if(visited[sr][sc]==false){
						q.add(new int[]{sr,sc});
						visited[sr][sc]=true;
					}
				}
			}
			level++;
		}
		return grid;
    }
}