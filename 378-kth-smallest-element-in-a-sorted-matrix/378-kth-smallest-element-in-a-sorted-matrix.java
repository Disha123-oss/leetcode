class Solution {
    public int smallerthanmid(int[][] matrix, int mid){
        int n = matrix.length, ans=0;
        for(int i=0;i<n;i++){
            if(matrix[i][0]>mid)
                return ans;
            else if(matrix[i][n-1]<=mid)
                ans+=n;
            else{
                int l = 0;
                int h = n-1;
                int temp = 0;
                while(l<=h){
                    int m = l+(h-l)/2;
                    if(matrix[i][m]<=mid){
                        temp = m;
                        l=m+1;
                    }
                    else
                        h=m-1;
                }
                ans+=temp+1;
            }
        }
        return ans;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int h = matrix[n-1][n-1];
        while(l<=h){
            int mid = l+(h-l)/2;
            if(smallerthanmid(matrix,mid)>=k)
                h=mid-1;
            else
                l=mid+1;
        }
        return l;
    }
}