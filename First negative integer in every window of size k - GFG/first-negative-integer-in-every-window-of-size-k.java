//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long a[], int n, int k)
    {
        int s=0,e=0,count=0,i=0;
        Queue<Integer> q = new LinkedList<>();
        long[] ans = new long[n-k+1];
        while(e<n){
            count++;
            if(a[e]<0) q.add(e);
            e++;
            
            while(count>k){
                s++;
                count--;
            }
            
            if(count==k){
                while(q.size()>0 && q.peek()<s)  q.remove();
                if(q.size()==0) ans[i++] = 0;
                else ans[i++] = a[q.peek()];
            }
        }
        return ans;
    }
}