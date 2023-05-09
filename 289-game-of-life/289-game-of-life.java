class Solution {
    public int neighbor(int[][] board, int i, int j){
        int n = board.length;
        int m = board[0].length;
        if(i<0 || j<0 || i>=n || j>=m || board[i][j]==0) return 0;
        return 1;
    }
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] res = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int sum = neighbor(board,i+1,j)+ neighbor(board,i-1,j)+ neighbor(board,i,j+1)+ neighbor(board,i,j-1)+ neighbor(board,i+1,j+1)+ neighbor(board,i-1,j+1)+ neighbor(board,i+1,j-1)+ neighbor(board,i-1,j-1);
                if(board[i][j]==1)
                    res[i][j] = ((sum<2 || sum>3) ? 0:1);
                else
                    res[i][j] = ((sum==3) ? 1:0);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j] = res[i][j];
            }
        }
    }
}