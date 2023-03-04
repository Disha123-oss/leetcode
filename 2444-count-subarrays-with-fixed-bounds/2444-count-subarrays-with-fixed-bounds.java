class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n=nums.length; // length of the array
        int lb=-1; // lower bound upto which all possible ans are taken 
        int curr_mink_index=-1; // curr index of minK
        int curr_maxk_index=-1; // curr index of maxK
        long ans=0;
        for(int i=0;i<n;i++){
            if(nums[i]>=minK && nums[i]<=maxK){ // if the value is in the range of minK and maxK we can calculate the ans
                if(nums[i]==minK) curr_mink_index=i; // upadate index of curr_mink
                if(nums[i]==maxK) curr_maxk_index=i; // update index of curr_maxk
                ans+=Math.max(0,Math.min(curr_mink_index,curr_maxk_index)-lb);  // Math.max(0,Math.min(curr_mink_index,curr_maxk_index)-lb) checks if the subarray is possible if not possible it will give negative value 
            }else{
                lb=i; // update the lb upto wgich all ans have taken into consideration
                curr_mink_index=-1; // update that now for this range we dont have mink we again have to calculae it
                curr_maxk_index=-1; // update that now for this range we dont have maxk we again have to calculae it
            }
            
        }
        return ans;
    }
}