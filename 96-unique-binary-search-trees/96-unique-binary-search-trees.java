class Solution {
    public int solve(int n, int[] dp) {
        if(n<=1)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=solve(i-1,dp)*solve(n-i,dp);
        }
        dp[n]=sum;
        return sum;
    }
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
}