//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        int st=0,e=0,sum=0,start=-1,end=-1;
        while(e<n){
            sum+=arr[e];
            e++;
            
            while(sum>s){
                sum-=arr[st];
                st++;
            }
            
            if(sum==s){
                start = st+1;
                end = e;
                break;
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        if(start==-1 && end==-1){
            al.add(-1);
            return al;
        }
        if(start > end){
            al.add(-1);
            return al;
        }
        al.add(start);
        al.add(end);
        return al;
    }
}