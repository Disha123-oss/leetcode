class Solution {
    public void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
    public int minMovesToMakePalindrome(String s) {
        int n = s.length();
        char[] ch = new char[n];
        ch  = s.toCharArray();
        int lt=0, rt=n-1, ans=0;
        while(lt<rt){
            int l=lt,r=rt;
            while(ch[l]!=ch[r])  r--;
            if(l==r){
                swap(ch,r,r+1);
                ans++;
                continue;
            }
            else{
                while(r<rt){
                    swap(ch,r,r+1);
                    ans++;
                    r++;
                }
            }
            lt++;
            rt--;
        }
        return ans;
    }
}