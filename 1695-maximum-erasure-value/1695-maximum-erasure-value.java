class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int s=0,e=0,n=nums.length,sum=0,repeat=0,max=0;
        Map<Integer,Integer> hm = new HashMap<>();
        while(e<n){
            //expansion
            hm.put(nums[e],hm.getOrDefault(nums[e],0)+1);
            if(hm.get(nums[e])>1)
                repeat++;
            sum+=nums[e];
            e++;
            
            //contraction
            while(repeat==1){
                if(hm.get(nums[s])>1)
                    repeat--;
                hm.put(nums[s],hm.get(nums[s])-1);
                sum-=nums[s];
                s++;
            }
            
            //calculation
            if(repeat==0)
                max=Math.max(max,sum);
        }
        return max;
    }
}