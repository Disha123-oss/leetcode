class Solution {
    public boolean check(String s,HashSet<Character> hs){
        for(int i=0;i<s.length();i++){
            if(!hs.contains(s.charAt(i)))
                return false;
        }
        return true;
    }
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<allowed.length();i++){
            hs.add(allowed.charAt(i));
        }
        int count=0;
        for(int i=0;i<words.length;i++){
            if(check(words[i],hs))
                count++;
        }
        return count;
    }
}