class Solution {
    public int findKthPositive(int[] arr, int k) {
       int s=0, e=arr.length-1;
       while(s<=e){
           int mid = s+((e-s)/2);
           int count = arr[mid]-(mid+1);
           if(count<k){
               s=mid+1;
           }
           else{
               e=mid-1;
           }
       }
       if(e<0)
           return k;
       return arr[e]+k-(arr[e]-(e+1));
    }
}