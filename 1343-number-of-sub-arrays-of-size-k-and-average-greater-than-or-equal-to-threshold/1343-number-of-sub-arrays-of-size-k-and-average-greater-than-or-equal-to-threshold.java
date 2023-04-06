class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int s=0,e=0,n=arr.length,count=0,ans=0,sum=0;
        while(e<n){
            //expansion
            count++; 
            sum+=arr[e]; 
            e++;
            
            //contraction
            while(count>k){
                sum-=arr[s];
                s++;
                count--;
            }
            
            //calculation
            if(count==k){
                if((sum/k)>=threshold)
                    ans++;
            }
        }
        return ans;
    }
}