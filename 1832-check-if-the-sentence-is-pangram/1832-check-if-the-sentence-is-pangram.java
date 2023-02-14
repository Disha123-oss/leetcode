class Solution {
    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        int[] fre = new int[26];
        for(int i=0;i<n;i++){
            if(sentence.charAt(i)==' ')
                continue;
            fre[sentence.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(fre[i]==0)
                return false;
        }
        return true;
    }
}