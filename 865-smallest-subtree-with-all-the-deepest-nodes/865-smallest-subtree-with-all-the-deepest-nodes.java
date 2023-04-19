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
    public int height(TreeNode root){
        if(root==null)  return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1+Math.max(left,right);
    }
    TreeNode ans = null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null) return null;
        int left = height(root.left);
        int right = height(root.right);
        if(left==right){  
            ans = root;
            return ans;
        }
        if(left>right)  root.left = subtreeWithAllDeepest(root.left);
        if(left<right)  root.right = subtreeWithAllDeepest(root.right);
        return ans;
    }
}