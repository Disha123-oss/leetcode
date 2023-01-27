class Solution {
    public int divide(int dividend, int divisor) {
        long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		long ans=0;
		while(a>=b){
			int bitpos=0;
			while(a>=(b<<bitpos)){
				bitpos++;
			}
			a-=(b<<(bitpos-1));
			ans+=(1L<<(bitpos-1));
		}
		if((dividend<=0 && divisor>0) || (dividend>=0  && divisor<0)) ans=-ans;
		if(ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
		if(ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
		return (int)ans;
    }
}