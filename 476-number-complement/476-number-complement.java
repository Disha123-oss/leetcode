class Solution {
    public boolean checkbit(int n, int k){
        return ((n&(1<<k))!=0);
    }
    public int findComplement(int num) {
        int ans=0;
        int len = Integer.toBinaryString(num).length();
        for(int i=0;i<len;i++){
            if(checkbit(num,i)==false){
                ans+=(1<<i);
            }
        }
        return ans;
    }
}