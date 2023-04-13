class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0, ans=0, n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                count++;
                ans+=count;
            }
            else
                count=0;
        }
        return ans;
    }
}