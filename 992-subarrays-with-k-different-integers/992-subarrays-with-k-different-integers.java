class Solution {
     public static int atmostk(int nums[], int n, int k) 
	{
        // Write your code here.   
        int s=0, e=0,count=0, distinct=0;
		Map<Integer,Integer> hm = new HashMap<>();
		while(e<n){
			//1.expansion
			hm.put(nums[e],hm.getOrDefault(nums[e], 0)+1);
            if(hm.get(nums[e])==1)  distinct++;
			e++;
			
			//2.contraction
			while(s<e && distinct>k){
				if(hm.get(nums[s])==1)  distinct--;
                hm.put(nums[s],hm.get(nums[s])-1);
				s++;
			}
            
            //3.calculation
            if(distinct<=k)  count+=(e-s);
		}
		return count; 
    }
     
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int ans = atmostk(nums,n,k) - atmostk(nums,n,k-1);
        return ans;
    }
}