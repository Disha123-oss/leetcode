class Solution {
    public int longestSubarray(int[] nums) {
        int s=0,e=0,n=nums.length,count=0,max=0;
        while(e<n){
            //expansion
            if(nums[e]==0) count++;
            e++;
            
            //contraction
            while(count>1){
                if(nums[s]==0) count--;
                s++;
            }
            
            //calculation
            if(count==1){
                max=Math.max(max,e-s-1);
            }
        }
        int zeroes=0,ones=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0)
                zeroes++;
            else
                ones++;
        }
        if(zeroes==n)  return 0;
        if(ones==n) return n-1;
        return max;
    }
}