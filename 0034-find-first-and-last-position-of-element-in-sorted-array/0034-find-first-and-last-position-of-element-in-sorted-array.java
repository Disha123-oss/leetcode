class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length, low=0, high=n-1, first=-1, last=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(target==nums[mid]){
                first=mid;
                high=mid-1;
            }
            else if(target<nums[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        low=0;high=n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(target==nums[mid]){
                last=mid;
                low=mid+1;
            }
            else if(target<nums[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        if(first!=-1 && last!=-1)
            return new int[]{first,last};
        return new int[]{-1,-1};
    }
}