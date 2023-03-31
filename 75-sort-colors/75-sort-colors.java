class Solution {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void sortColors(int[] nums) {
        int p1=-1, p2=0, p3=nums.length-1;
        while(p2<=p3){
            if(nums[p2]==0){
                p1++;
                swap(nums,p1,p2);
                p2++;
            }
            else if(nums[p2]==1){
                p2++;
            }
            else{
                swap(nums,p2,p3);
                p3--;
            }
        }
    }
}