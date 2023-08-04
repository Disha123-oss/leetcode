//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            StringBuilder out = new StringBuilder();
            ans = ob.jugglerSequence(N);
            for(int i = 0;i < ans.size();i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void sequence(int n, List<Integer> ans){
        ans.add(n);
        if(n<=1) 
            return;
        else if(n%2==0){
            int s = (int)Math.floor(Math.sqrt(n));
            sequence(s,ans);
        }
        else{
            int s = (int)Math.floor(Math.sqrt(n)*n);
            sequence(s,ans);
        }
    }
    static List<Integer> jugglerSequence(int N){
        // code here
        List<Integer> ans = new ArrayList<>();
        sequence(N,ans);
        return ans;
    }
}