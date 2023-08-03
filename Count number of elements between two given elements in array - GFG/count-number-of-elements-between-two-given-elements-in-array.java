//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    int n = Integer.parseInt(br.readLine());
		    int arr[] = new int[n];
		    
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split(" ");
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    line = br.readLine();
		    String element[] = line.trim().split(" ");
		    int num1 = Integer.parseInt(element[0]);
		    int num2 = Integer.parseInt(element[1]);
		    
		    Solution obj = new Solution();
		    
		    int v = obj.getCount(arr,n,num1,num2);
            System.out.println(v);
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    
    static int getCount(int arr[], int n, int num1, int num2) 
    { 
        // Complete the function
        int first=-1, sec=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==num1 && first==-1){
                first = i;
            }
            if(arr[i]==num2){
                sec = i;
            }
        }
        int ans = sec-first-1;
        if(ans==-1) return 0;
        return ans;
    }
}

