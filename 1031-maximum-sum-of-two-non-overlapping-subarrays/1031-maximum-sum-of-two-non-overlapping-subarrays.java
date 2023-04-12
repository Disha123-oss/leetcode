class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int f, int s) {
        int n = nums.length;
        int[] pre = new int[n+1];
        for(int i=1;i<=n;i++){
            pre[i]=pre[i-1]+nums[i-1];
        }
        int max=0;
        int maxf=0;
        for(int i=f;i<=n-s;i++){
            maxf = Math.max(maxf,pre[i]-pre[i-f]);
            max = Math.max(max,pre[i+s]-pre[i]+maxf);
        }
        int maxs=0;
        for(int i=s;i<=n-f;i++){
            maxs = Math.max(maxs,pre[i]-pre[i-s]);
            max = Math.max(max,pre[i+f]-pre[i]+maxs);
        }
        return max;
    }
}