class Solution {
    public int search(int[] arr, int key) {
        int s=0,e=arr.length-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(key==arr[mid])   return mid;
            else if(arr[s]<arr[mid]){
                if(arr[s]<=key && key<arr[mid])
                    e=mid-1;
                else
                    s=mid+1;
            }
            else{
                if(mid+1<arr.length && arr[mid+1]<=key && key<=arr[e])
                    s=mid+1;
                else
                    e=mid-1;
            }
        }
        return -1;
    }
}