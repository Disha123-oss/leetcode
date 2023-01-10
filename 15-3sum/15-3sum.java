class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i=0,j=0,k=0;
		List<Integer> al = new ArrayList<>();
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		while(i<nums.length-2){
			j=i+1;
			k=nums.length-1;
			while(j<k){
				if(nums[i]+nums[j]+nums[k]<0)
					j++;
				else if(nums[i]+nums[j]+nums[k]>0)
					k--;
				else if(nums[i]+nums[j]+nums[k]==0){
					al.add(nums[i]);
					al.add(nums[j]);
					al.add(nums[k]);
                    if(!list.contains(al))
                        list.add(al);
                    al = new ArrayList<>();
                    j++;
				}
			}
			i++;
		}
		return list;
    }
}