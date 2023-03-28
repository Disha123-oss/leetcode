class Solution {
    public boolean isPalindrome(String s) {
        String str = "";
        for(int i=0;i<s.length();i++){
            int val = (int)(s.charAt(i));
            if(val>=65 && val<=90)
                str+=(char)(val+32);
            else if(val>=97 && val<=122)
                str+=s.charAt(i);
            else if(val>=48 && val<=57)
                str+=s.charAt(i);
        }
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}