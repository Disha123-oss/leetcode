class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        int n = nums.length, max=0, cnt=0, curr=Integer.MIN_VALUE;
        if(n==0) return 0;
        for(int i=0;i<n;i++){
            hs.add(nums[i]);
        }
        for(int ele : hs){
            if(!hs.contains(ele-1)){
                curr=ele;
                cnt=1;
                while(hs.contains(curr+1)){
                    curr++;
                    cnt++;
                    max = Math.max(max,cnt);
                }
                max = Math.max(max,cnt);
            }
        }
        return max;
    }
}