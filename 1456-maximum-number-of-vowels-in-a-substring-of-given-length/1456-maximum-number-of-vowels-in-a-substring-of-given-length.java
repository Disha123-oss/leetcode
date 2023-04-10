class Solution {
    public int maxVowels(String str, int k) {
        int s=0,e=0,count=0,vowels=0,n = str.length(),max=0;
        while(e<n){
            //expansion
            if(str.charAt(e)=='a' || str.charAt(e)=='e' || str.charAt(e)=='i' || str.charAt(e)=='o' || str.charAt(e)=='u')
                vowels++;
            count++;
            e++;
            
            //contraction
            while(count>k){
                if(str.charAt(s)=='a' || str.charAt(s)=='e' || str.charAt(s)=='i' || str.charAt(s)=='o' || str.charAt(s)=='u')
                    vowels--;
                count--;
                s++;
            }
            
            //calculation
            if(count==k)
                max=Math.max(max,vowels);
        }
        return max;
    }
}