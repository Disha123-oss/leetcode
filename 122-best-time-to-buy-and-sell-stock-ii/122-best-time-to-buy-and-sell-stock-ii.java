class Solution {
    public int maxProfit(int[] values) {
        int n = values.length, profit = 0;
        for(int i=1;i<n;i++){
            if(values[i]>values[i-1])
                profit+=values[i]-values[i-1];
        }
        return profit;
    }
}