class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        int max = 0, diff=0;
        for(int i=n-1;i>=0;i--){
            if(prices[i]>max){
                max=prices[i];
            }
            ans[i]=max;
            diff=Math.max(diff,ans[i]-prices[i]);
        }
        return diff;
    }
}