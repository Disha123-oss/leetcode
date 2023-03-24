class Solution {
    public int findMin(int[] arr) {
        int n=arr.length,i=0,j=n-1,pivot=0;
        while(i<j){
            int mid = (i+j)/2;
            if(mid+1<n && arr[mid]>arr[mid+1]){
                pivot=mid+1;
                break;
            }
            else if(mid-1>=0 && arr[mid-1]>arr[mid]){
                pivot=mid;
                break;
            }

            if(arr[mid]>arr[j])
                i=mid+1;
            else
                j=mid-1;
        }
        return arr[pivot];
    }
}