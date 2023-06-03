class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if(n<4){
            List<List<Integer>> list = new ArrayList<>();
            return list;
        }
        Arrays.sort(nums);
        Set<List<Integer>> hs = new HashSet<>();
        for(int i=0;i<n-3;i++){
            while(i>0 && i<n-3 && nums[i]==nums[i-1]) i++;
            for(int j=i+1;j<n-2;j++){
                while(j>i+1 && j<n-2 && nums[j]==nums[j-1]) j++;
                int k = j+1;
                int l = n-1;
                while(k<l){
                    long sum = nums[i];
                    sum+=nums[j];
                    sum+=nums[k];
                    sum+=nums[l];
                    if(sum==target){
                        hs.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }
                    else if(sum<target)
                        k++;
                    else
                        l--;
                }
            }
        }
        return new ArrayList<>(hs);
    }
}