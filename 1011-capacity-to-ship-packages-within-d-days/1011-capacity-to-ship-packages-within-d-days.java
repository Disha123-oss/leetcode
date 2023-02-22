class Solution {
    public boolean isPossible(int weight, int[] weights, int days){
        int count=1;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            if(sum>weight)
                return false;
            if(i+1<weights.length && (sum+weights[i+1]>weight)){
                sum=0;
                count++;
            }
        }
        return count<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
        }
        int s=1,e=sum,ans=-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(isPossible(mid,weights,days)){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
}