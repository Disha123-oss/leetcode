class Solution {
     static int[] dr = {-1,0,0,1};
  static int[] dc = {0,-1,1,0};
  public static void dfs(int i, int j, int[][] grid){
	  grid[i][j]=0;
	  for(int l=0;l<4;l++){
		  int r = i+dr[l];
		  int c = j+dc[l];
		  if(r<0 || r>=grid.length || c<0 || c>=grid[0].length)  continue;
		 
		  if(grid[r][c]==1){
			  dfs(r,c,grid);
		  }
	  }
  }
    public int numEnclaves(int[][] grid) {
        int count=0;
	  for(int i=0;i<grid.length;i++){
		  for(int j=0;j<grid[0].length;j++){ 
			  if((i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1) && grid[i][j]==1){
				  dfs(i,j,grid);   //if it is a boundary cell call dfs
			  }
		  }
	  }
	   for(int i=0;i<grid.length;i++){
		  for(int j=0;j<grid[0].length;j++){ 
			  if(grid[i][j]==1){
				  count++;   //count the 1s left in the grid
			  }
		  }
	  }
	  return count;
    }
}