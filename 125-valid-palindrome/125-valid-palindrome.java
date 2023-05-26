class Solution {
    public boolean palin(String s, int st, int e){
        if(st>=e) return true;
        if(s.charAt(st)!=s.charAt(e)) return false;
        boolean ans = palin(s,st+1,e-1);
        return ans;
    }
    public boolean isPalindrome(String s) {
        int n = s.length();
        s = s.toLowerCase();
        String str = "";
        for(int i=0;i<n;i++){
            if((s.charAt(i)<=122 && s.charAt(i)>=97) || (s.charAt(i)>=48 && s.charAt(i)<=57))
                str+=s.charAt(i);
        }
        n=str.length();
        return palin(str,0,n-1);
    }
}