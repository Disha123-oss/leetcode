class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
       int count=0;
       for(int i=0;i<nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[j]-nums[i]==diff && nums[k]-nums[j]==diff){
                    count++;
                    j++;
                }
                else if(nums[j]-nums[i]<diff)
                    j++;
                else if(nums[k]-nums[j]>diff)
                    k--;
                else
                    break;
            }
       }
        return count;
    }
}