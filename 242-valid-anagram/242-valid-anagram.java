class Solution {
    public boolean isAnagram(String s, String t) {
        int[] fres = new int[26];
        int[] fret = new int[26];
        for(int i=0;i<s.length();i++){
            fres[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            fret[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(fres[i]!=fret[i])
                return false;
        }
        return true;
    }
}