class Solution {
    public int maxProfit(int[] prices) {
        int[] arr = new int[prices.length];
        arr[arr.length-1]=prices[prices.length-1];
        for(int i=arr.length-2;i>=0;i--){
            if(prices[i]>arr[i+1])
                arr[i]=prices[i];
            else
                arr[i]=arr[i+1];
        }
        int max=0;
        for(int i=0;i<prices.length;i++){
            max=Math.max(max,arr[i]-prices[i]);
        }
        return max;
    }
}