class Solution {
    public boolean check(HashMap<Character,Integer> hm1, HashMap<Character,Integer> hm2){
        for(char ch : hm2.keySet()){
            if(hm1.containsKey(ch)){
                if(hm1.get(ch) < hm2.get(ch))
                    return false;
            }
            else
                return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int st=0,e=0,n=s.length(),min=Integer.MAX_VALUE,start=-1,end=-1;
        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();
        for(int i=0;i<t.length();i++){
            hm2.put(t.charAt(i),hm2.getOrDefault(t.charAt(i),0)+1);
        }
        while(e<n){
            //expansion
            hm1.put(s.charAt(e),hm1.getOrDefault(s.charAt(e),0)+1);
            e++;
            
            //contraction
            while(check(hm1,hm2)){
                if(min>(e-st)){
                    min=Math.min(min,e-st);
                    start=st;
                    end=e;
                }
                if(hm1.getOrDefault(s.charAt(st),0)==1)
                    hm1.remove(s.charAt(st));
                else
                    hm1.put(s.charAt(st),hm1.getOrDefault(s.charAt(st),0)-1);
                st++;
            }
        }
        if(start==-1 && end==-1)   return "";
        return s.substring(start,end);
    }
}