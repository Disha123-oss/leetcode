class Solution {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void moveZeroes(int[] nums) {
        int n=nums.length, i=0, j=1;
        if(n==1) return;
        while(i<n && j<n){
            if(nums[i]==0){
                swap(nums,i,j);
                j++;
            }
            else{
                i++;
                if(i==j) j++;
            }
        }
    }
}