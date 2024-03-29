class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, xor=0;
        for(int i=0;i<n;i++){
            xor^=nums[i];
            xor^=i;
        }
        xor^=n;
        return xor;
    }
}