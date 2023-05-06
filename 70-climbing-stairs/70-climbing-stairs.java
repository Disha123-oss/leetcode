class Solution {
    public int count(int n, int[] dp) {
		// Write your code here.
		if(n==0 || n==1) return 1;
		if(dp[n]!=0) return dp[n];
		dp[n] = count(n-1,dp) + count(n-2,dp);
		return dp[n];
	}
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return count(n,dp);
    }
}