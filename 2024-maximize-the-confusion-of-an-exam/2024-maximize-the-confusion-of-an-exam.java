class Solution {
    public int maxConsecutiveAnswers(String ans, int k) {
        int s=0,e=0,n=ans.length(),count=0,max=0,first=0;
        while(e<n){
            //expansion
            if(ans.charAt(e)=='T')
                count++;
            e++;
            
            //calculation
            if(count<=k)
                first=Math.max(first,e-s);
            
            //contraction
            while(count>k){
                if(ans.charAt(s)=='T')
                    count--;
                s++;
            }
        }
        
        s=0;e=0;count=0;max=0;int sec=0;
        while(e<n){
            //expansion
            if(ans.charAt(e)=='F')
                count++;
            e++;
            
            //calculation
            if(count<=k)
                sec=Math.max(sec,e-s);
            
            //contraction
            while(count>k){
                if(ans.charAt(s)=='F')
                    count--;
                s++;
            }
        }
        return Math.max(first,sec);
    }
}