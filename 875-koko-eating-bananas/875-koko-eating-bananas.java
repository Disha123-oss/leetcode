class Solution {
    public boolean isPossible(int[] piles, int mid, int h){
        int count=0;
        for(int i=0;i<piles.length;i++){
            count += Math.ceil((double)piles[i]/mid);
        }
        return count<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        int s=1,e=max,ans=-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(isPossible(piles,mid,h)){
                ans=mid;
                e=mid-1;
            }
            else
                s=mid+1;
        }
        return ans;
    }
}