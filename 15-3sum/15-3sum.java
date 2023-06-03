class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n-2;i++){
            while(i>0 && i<n-2 && nums[i]==nums[i-1]) i++;
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    ArrayList<Integer> al = new ArrayList<>();
                    al.addAll(Arrays.asList(nums[i],nums[j],nums[k]));
                    list.add(al);
                    j++; k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
                else if(sum<0)
                    j++;
                else if(sum>0)
                    k--;
            }
        }
        return list;
    }
}