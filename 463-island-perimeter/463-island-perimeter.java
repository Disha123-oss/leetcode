class Solution {
    public int islandPerimeter(int[][] arr) {
                int row=arr.length;
                int col=arr[0].length;
                int peri=0;
                for(int i=0;i<row;i++){
                    for(int j=0;j<col;j++){
                        if(arr[i][j]==1){
							peri+=4;
							if(i>0 && arr[i-1][j]==1)
								peri-=2;
							if(j>0 && arr[i][j-1]==1)
								peri-=2;
						}
                    }
                }
                return peri;
    }
}