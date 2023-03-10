class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length,sum=0,pos=0,total=0;
        for(int i=0;i<n;i++){
            sum += gas[i]-cost[i];
            if(sum<0){
                total += sum;
                sum=0;
                pos = i+1;
            }
        }
        if(total+sum>=0)
            return pos;
        return -1;
    }
}