class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long start=1,end=1L*totalTrips*time[0],mid,ans=0;
        while(start<=end){
          mid=start+(end-start)/2;
          boolean flag=checkTrips(time,totalTrips,mid);
          if(flag){
              ans=mid;
              end=mid-1;
          }else{
              start=mid+1;
          }
        }
        return ans==0?time[0]*totalTrips:ans;
    }
    private boolean checkTrips(int[] time,int totalTrips,long duration){
        int len=time.length;
        long sum=0;
        for(int i=0;i<len;i++) sum=sum+(duration/time[i]);
        if(sum>=totalTrips)  return true;
        return false;
    }
}