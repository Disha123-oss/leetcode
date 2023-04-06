class Solution {
    public int numberOfSubstrings(String s) {
        int st=0,e=0,n=s.length(),flag=0,ans=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        while(e<n){
            //expansion
            hm.put(s.charAt(e),hm.getOrDefault(s.charAt(e),0)+1);
            e++;
            
            //contraction
            while(hm.containsKey('a') && hm.containsKey('b') && hm.containsKey('c')){
                ans+=n-e+1;
                if(hm.get(s.charAt(st))==1)
                    hm.remove(s.charAt(st));
                else
                    hm.put(s.charAt(st),hm.get(s.charAt(st))-1);
                st++;
            }
        }
        return ans;
    }
}