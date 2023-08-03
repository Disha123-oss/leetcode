//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            ArrayList<String> ans = ob.extractIntegerWords(s);
            if(ans.size()==0)
                System.out.println("No Integers");
            else{
                for(int i=0;i<ans.size();i++)
                    System.out.print(ans.get(i)+" ");
                System.out.println();
            }
        }
    } 
} 
// } Driver Code Ends


//Back-end complete function Template for Java
class Solution 
{ 
    ArrayList<String> extractIntegerWords(String s) 
    { 
        ArrayList<String> ans = new ArrayList<String>();
        StringBuilder tmp = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)<'0'||s.charAt(i)>'9')
                continue;
            tmp.append(s.charAt(i));
            if(i+1<s.length()&&'0'<=s.charAt(i+1)&&s.charAt(i+1)<='9')
                continue;
            ans.add(tmp.toString());
            tmp.delete(0,tmp.length());
        }
        return ans;    
    }
} 