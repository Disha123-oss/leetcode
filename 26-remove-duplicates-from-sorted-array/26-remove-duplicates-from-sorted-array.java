class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length, s=0, e=1;
        while(e<n){
            if(nums[s]==nums[e]) e++;
            else {
                s++;
                nums[s] = nums[e];
                e++;
            }
        }
        return s+1;
    }
}