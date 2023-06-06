//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    boolean checkbit(int num, int i){
        int ans = (num & (1<<i));
        if(ans==0) return false;
        return true;
    }
    int[] findTwoElement(int arr[], int n) {
        // code here
        int xor = 0;
        for(int i=0;i<n;i++){
            xor^=arr[i];
            xor^=(i+1);
        }
        int pos=-1;
        for(int i=31;i>=0;i--){
            if(checkbit(xor,31-i)){
                pos=i;
                break;
            }
        }
        int cnt1=0, cnt2=0, cnt=0;
        for(int i=0;i<n;i++){
            if(checkbit(arr[i],31-pos))
                cnt1^=arr[i];
            else
                cnt2^=arr[i];
        }
        for(int i=1;i<=n;i++){
            if(checkbit(i,31-pos))
                cnt1^=i;
            else
                cnt2^=i;
        }
        for(int i=0;i<n;i++){
            if(arr[i]==cnt1)
                cnt++;
        }
        if(cnt==2) return new int[]{cnt1,cnt2};
        return new int[]{cnt2,cnt1};
    }
}