class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);   //sorting the array   -4,-1,1,2
        int i=0,j=0,k=0;
        int min = Integer.MAX_VALUE, ans=0;
        while(i<=nums.length-3){    //using three pointers i,j, and k for sum
            j=i+1;
            k=nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];  //sum of three nos
                int diff = Math.abs(target-sum);    //diff of sum with target
                if(min>diff){
                    min=Math.min(min,diff);
                    ans=sum;
                }
                if(sum>target)   //sum greater than target
                    k--;
                else if(sum<target)    //sum less than target
                    j++;
                else
                    break;
            }
            i++;
        }
        return ans;
    }
}