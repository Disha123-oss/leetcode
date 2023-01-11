class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int s=0,e=0,pro=1,count=0;
		while(s<=e && e<nums.length){
			pro *= nums[e];
			if(pro<k){
				if(e==nums.length-1){
					e=nums.length-1;
					count += nums.length-s;
					pro=pro/(nums[s]*nums[e]);
					s++;
				}
				else
					e++;
				
			}
            else if(pro>=k && s==e){
                pro=pro/nums[e];
                s++;
                e++;
            }
			else{
				count += e-s;
				pro=pro/(nums[s]*nums[e]);
				s++;
			}
           
		}
		return count;
    }
}