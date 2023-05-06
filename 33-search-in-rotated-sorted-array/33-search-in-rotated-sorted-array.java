class Solution {
    public int search(int[] arr, int key) {
        int n=arr.length,low=0,hi=n-1;
        while(low<=hi){
            int mid = (low+hi)/2;
            if(arr[mid]==key)
                return mid;
            else if(arr[low]<arr[mid]){
                if(key>=arr[low] && key<arr[mid])
                    hi=mid-1;
                else
                    low=mid+1;
            }
            else{
                if(mid+1<n && key>=arr[mid+1] && key<=arr[hi])
                    low=mid+1;
                else
                    hi=mid-1;
            }
        }
        return -1;
    }
}