class Solution {
    public void reverse(int[] arr, int s, int e){
        while(s<e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
    public void rotate(int[] arr, int d) {
        int n = arr.length;
        d=d%n;
        int k = n-d;
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        reverse(arr,0,n-1);
    }
}