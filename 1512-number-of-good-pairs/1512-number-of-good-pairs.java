class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                count += hm.get(nums[i]);
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else
                hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
}