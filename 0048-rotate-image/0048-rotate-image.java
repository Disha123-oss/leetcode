class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<m;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<n;i++){
            int s=0, e=m-1;
            while(s<e){
                int temp = matrix[i][s];
                matrix[i][s] = matrix[i][e];
                matrix[i][e] = temp;
                s++;
                e--;
            }
        }
    }
}