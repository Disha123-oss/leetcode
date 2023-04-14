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
    public int sum(TreeNode root){
        if(root==null)  return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        return left+right+root.val;
    }
    public int nodes(TreeNode root){
        if(root==null)  return 0;
        int left = nodes(root.left);
        int right = nodes(root.right);
        return 1+left+right;
    }
    int count=0;
    public void avg(TreeNode root){
        if(root==null)  return;
        if(root.left==null && root.right==null){
            count++;
            return;
        }
        avg(root.left);
        avg(root.right);
        int ans = sum(root)/nodes(root);
        if(root.val==ans)
            count++;
    }
    public int averageOfSubtree(TreeNode root) {
        avg(root);
        return count;
    }
}