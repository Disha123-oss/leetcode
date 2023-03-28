class Solution {
    public int lengthOfLongestSubstring(String str) {
        int s=0,e=0,n=str.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        int repeat=0, max=0;
        while(e<n){
            //expansion
            hm.put(str.charAt(e),hm.getOrDefault(str.charAt(e),0)+1);
            if(hm.get(str.charAt(e))>1)
                repeat++;
            e++;
            
            //calculation
            if(repeat==0)
                max = Math.max(max,e-s);
            
            //contraction
            while(repeat>0){
                if(hm.get(str.charAt(s))>1)
                    repeat--;
                if(hm.get(str.charAt(s))==1)
                    hm.remove(str.charAt(s));
                else
                    hm.put(str.charAt(s),hm.get(str.charAt(s))-1);
                s++;
            }
        }
        return max;
    }
}