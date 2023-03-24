class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int i = 0, j = 0;
        while(j < nums.length){
            if(nums[j] != 0){
                j++;
                i = j;
            }else{
                count += j - i + 1;
                j++;
            }
        }
        return count;
    }
}