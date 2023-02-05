class Solution {
    public int longestOnes(int[] nums, int k) {
        int s=0, e=0, max=0, flips=0;
        while(e<nums.length){
            //expansion
            if(nums[e]==0) flips++;
            e++;
            
            //contraction
            while(s<e && flips>k){
                if(nums[s]==0) flips--;
                s++;
            }
            
            //calculation
            max=Math.max(max,e-s);
        }
        return max;
    }
}