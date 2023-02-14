class Solution {
    public String decodeMessage(String key, String message) {
        int[] fre = new int[26];
        char[] sub = new char[26];
        int j=0;
        for(int i=0;i<key.length();i++){
            if(key.charAt(i)==' ')
                continue;
            if(fre[key.charAt(i)-'a']==0)
                sub[j++]=key.charAt(i);
            fre[key.charAt(i)-'a']++;
        }
        Map<Character,Character> hm = new HashMap<>();
        for(int i=0;i<sub.length;i++){
            char ch = (char)(i+'a');
            hm.put(sub[i],ch);
        }
        String str="";
        for(int i=0;i<message.length();i++){
            if(message.charAt(i)==' '){
                str += ' ';
                continue;
            }
            str += hm.get(message.charAt(i));
        }
        return str;
    }
}