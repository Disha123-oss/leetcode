class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //make even as 0 and odd as 1 to make this question similar to
        //finding number of subarrays whose sum = k
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0)
                nums[i]=0;
            else
                nums[i]=1;
        }
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int sum=0,count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(hm.containsKey(sum-k))
                count+=hm.get(sum-k);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
}