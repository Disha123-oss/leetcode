class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> al = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String str = words[i];   //abc
            HashMap<Character,Character> hm = new HashMap<>();
            HashSet<Character> hs = new HashSet<>();
            int flag=0;
            for(int j=0;j<pattern.length();j++){
                if(hm.containsKey(pattern.charAt(j))){
                    if(hm.get(pattern.charAt(j))!=str.charAt(j)){
                        flag=1;
                        break;
                    }
                }
                else{
                    if(!hs.contains(str.charAt(j))){
                        hm.put(pattern.charAt(j),str.charAt(j));
                        hs.add(str.charAt(j));
                    }
                    else{
                        flag=1;
                    }
                }
            }
            if(flag==0)
                al.add(words[i]);
        }
        return al;
    }
}