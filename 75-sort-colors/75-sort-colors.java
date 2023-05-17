class Solution {
    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
        int p1=-1,p2=0,p3=nums.length-1;
        while(p2<=p3){
            if(nums[p2]==2){
                swap(nums,p2,p3);
                p3--;
            }
            else if(nums[p2]==0){
                p1++;
                swap(nums,p1,p2);
                p2++;
            }
            else{
                p2++;
            }
        }
    }
}