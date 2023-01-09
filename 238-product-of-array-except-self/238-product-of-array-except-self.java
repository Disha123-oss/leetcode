class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
		int[] prefix = new int[nums.length];
		int[] suffix = new int[nums.length];
	    prefix[0]=nums[0];
	    for(int i=1;i<nums.length;i++){
			prefix[i] = prefix[i-1] * nums[i];
		}
	    suffix[nums.length-1]=nums[nums.length-1];
	    for(int i=nums.length-2;i>=0;i--){
			suffix[i] = suffix[i+1] * nums[i];
		}
	    ans[0] = suffix[1];
		ans[nums.length-1] = prefix[nums.length-2];
		for(int i=1;i<nums.length-1;i++){
			ans[i] = prefix[i-1] * suffix[i+1];
		}
	    return ans;
    }
}