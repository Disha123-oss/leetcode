class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, max=0, cnt=0, curr=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]-1==curr){
                cnt++;
                curr = nums[i];
            }
            else if(nums[i]!=curr){
                curr = nums[i];
                cnt=1;
            }
            max = Math.max(max,cnt);
        }
        return max;
    }
}