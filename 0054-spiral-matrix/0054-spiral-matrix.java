class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int left=0, right=m-1, top=0, down=n-1, dir=1;
        ArrayList<Integer> al = new ArrayList<>();
        while(left<=right && top<=down){
            if(dir==1){
                for(int i=left;i<=right;i++){
                    al.add(matrix[top][i]);
                }
                top++;
                dir=2;
            }
            else if(dir==2){
                for(int i=top;i<=down;i++){
                    al.add(matrix[i][right]);
                }
                right--;
                dir=3;
            }
            else if(dir==3){
                for(int i=right;i>=left;i--){
                    al.add(matrix[down][i]);
                }
                down--;
                dir=4;
            }
            else{
                for(int i=down;i>=top;i--){
                    al.add(matrix[i][left]);
                }
                left++;
                dir=1;
            }
        }
        return al;
    }
}