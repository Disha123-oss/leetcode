class Solution {
    public int compress(char[] chars) {
        String s = "";
        int count=1;
        for(int i=0;i<chars.length-1;i++){
            if(chars[i]==chars[i+1]){
                if(count==1){
                    s+=chars[i];
                }
                count++;
            }
            else if(count>1 && chars[i]!=chars[i+1]){
                s+=count;
                count=1;
            }
            else if(count==1 && chars[i]!=chars[i+1]){
                s+=chars[i];
                count=1;
            }
            if(i==chars.length-2 && count>1)
                s+=count;
            else if(i==chars.length-2 && count==1)
                s+=chars[i+1];
        }
        for(int i=0;i<s.length();i++){
            chars[i] = s.charAt(i);
        }
        if(s.length()==0)
            return chars.length;
        return s.length();
    }
}