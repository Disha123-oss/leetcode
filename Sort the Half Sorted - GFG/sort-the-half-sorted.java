//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		new Solution().sortHalves (arr, n);
    	    for (int i = 0; i < n; ++i)
    	        System.out.print (arr[i] + " ");
    	    System.out.println ();
        }
        
    }
}

// Contributed By: Pranay Bansal
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static void sortHalves (int arr[], int n)
    {
        // your code here
        int[] ans = new int[n];
        int ind=0;
        for(ind=0;ind<n;ind++){
            if(ind+1<n && arr[ind]>arr[ind+1])
                break;
        }
        if(ind==n){
            return;
        }
        int j = ind+1, mid = ind+1, i=0, k=0;
        while(i<mid && j<n){
            if(arr[i]<=arr[j]){
                ans[k++] = arr[i];
                i++;
            }
            else{
                ans[k++] = arr[j];
                j++;
            }
        }
        while(i<mid){
            ans[k++] = arr[i];
            i++;
        }
        while(j<n){
            ans[k++] = arr[j];
            j++;
        }
        for(i=0;i<n;i++){
            arr[i] = ans[i];
        }
    }
}