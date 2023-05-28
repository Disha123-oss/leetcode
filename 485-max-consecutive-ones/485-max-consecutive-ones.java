class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length, max=0, count=0, zero=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0) zero++;
        }
        if(zero==n) return 0;
        for(int i=0;i<n-1;i++){
            if(nums[i]==1 && nums[i+1]==1){
                count++;
                max = Math.max(max,count);
            }
            else
                count=0;
        }
        return max+1;
    }
}