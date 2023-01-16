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
    public boolean search(TreeNode root, int k){
        if(root==null) return false;
        boolean ans = false;
        if(root.val<k)   ans=search(root.right,k);
        else if(root.val>k)   ans=search(root.left,k);
        else if(root.val==k)  return true;
        return ans;
    }
    boolean flag = false;
    public void find(TreeNode root, TreeNode curr, int k){
        if(curr==null)  return;
        find(root,curr.left,k);
        if(search(root,k-curr.val)==true && curr.val!=k-curr.val)
            flag=true;
        find(root,curr.right,k);
    }
    public boolean findTarget(TreeNode root, int k) {
        find(root,root,k);
        return flag;
    }
}