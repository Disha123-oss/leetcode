class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, i=0,j=1;
        if(n<2) return;
        while(j<n){
            if(nums[i]==0 && nums[j]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
            else if(nums[i]==0 && nums[j]==0)
                j++;
            else{
                i++;
                j++;
            }
        }
    }
}