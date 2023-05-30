class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for(int i=0;i<m;i++){
            int s=0, e=n-1;
            while(s<=e){
                int mid = (s+e)/2;
                if(matrix[i][mid]==target)
                    return true;
                else if(matrix[i][mid]>target)
                    e=mid-1;
                else
                    s=mid+1;
            }
        }
        return false;
    }
}