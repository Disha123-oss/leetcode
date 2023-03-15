class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0 || nums[i]>nums.length)
                nums[i]=nums.length+1;
        }
        for(int i=0;i<nums.length;i++){
            int ind = Math.abs(nums[i]);
            if(ind<=nums.length){
                if(nums[ind-1]>0)
                    nums[ind-1] = -nums[ind-1];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                return i+1;
        }
        return nums.length+1;
    }
}