class Solution {
    public int numberOfSubstrings(String s) {
        int st=0,e=0,n=s.length(),ans=0;
        int[] fre = new int[3];
        while(e<n){
            //expansion
            fre[s.charAt(e)-'a']++;
            e++;
            
            //contraction
            while(fre[0]>0 && fre[1]>0 && fre[2]>0){
                ans+=n-e+1;
                fre[s.charAt(st)-'a']--;
                st++;
            }
        }
        return ans;
    }
}