class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int s=0,e=0,n=nums.length,sum=0,count=0;
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        while(e<n){
            sum+=nums[e];
            if(hm.containsKey(sum-goal))
                count+=hm.get(sum-goal);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
            e++;
        }
        return count;
    }
}