class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length, xor = 0;
        for(int i=0;i<n;i++){
            xor^=nums[i];
        }
        return xor;
    }
}