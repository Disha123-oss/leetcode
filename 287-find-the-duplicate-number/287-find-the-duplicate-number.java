class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int index = Math.abs(nums[i]);
            if(nums[index-1]>0)
                nums[index-1] = -nums[index-1];
            else
                return index;
        }
        return -1;
    }
}