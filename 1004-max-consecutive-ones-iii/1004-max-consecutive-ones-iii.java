class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, s=0, e=0, zeroes=0, max=0;
        while(e<n){
            //expansion
            if(nums[e]==0) zeroes++;
            e++;
            
            //contraction
            while(zeroes>k){
                if(nums[s]==0) zeroes--;
                s++;
            }
            
            //calculation
            max = Math.max(max,e-s);
        }
        return max;
    }
}