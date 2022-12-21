class Solution {
    public static int floor_row(int[][] matrix, int ele){
		int s=0, e=matrix.length-1, ans=-1;
		while(s<=e){
			int mid=(s+e)/2;
			if(matrix[mid][0]==ele) 
				return mid;
			else if(matrix[mid][0]<ele){
				ans=mid;
				s=mid+1;
			}
			else
				e=mid-1;
		}
		return ans;
	}
	public static boolean binarysearch(int[][] matrix, int row, int ele){
		int s=0, e=matrix[0].length-1;
        while(s<=e){
			int mid=(s+e)/2;
			if(matrix[row][mid]==ele){
				return true;
			}
			else if(matrix[row][mid]<ele)
				s=mid+1;
			else
				e=mid-1;
		}
		return false;
	}
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = floor_row(matrix,target);
        if(row==-1) return false;
        boolean ans = binarysearch(matrix,row,target);
        return ans;
    }
}