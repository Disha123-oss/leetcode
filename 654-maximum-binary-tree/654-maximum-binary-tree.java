/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findmax(int[] arr, int s, int e){
        int max = 0;
        int idx = -1;
        for(int i=s;i<=e;i++){
            if(arr[i]>max){
                max=arr[i];
                idx=i;
            }
        }
        return idx;
    }
    public TreeNode construct(int[] arr, int s, int e){
        if(s>e)  return null;
        if(s==e) return new TreeNode(arr[s]);
        int idx = findmax(arr,s,e);
        TreeNode root = new TreeNode(arr[idx]);
        root.left = construct(arr,s,idx-1);
        root.right = construct(arr,idx+1,e);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n=nums.length;
        TreeNode root =  construct(nums,0,n-1);
        return root;
    }
}