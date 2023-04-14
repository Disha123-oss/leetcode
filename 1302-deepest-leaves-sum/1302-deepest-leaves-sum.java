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
    public int depth(TreeNode root){
        if(root==null)  return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left,right)+1;
    }
    int s=0;
    public void sum(TreeNode root, int depth){
        if(root==null)  return;
        if(depth==1)  s+=root.val;
        sum(root.left,depth-1);
        sum(root.right,depth-1);
    }
    public int deepestLeavesSum(TreeNode root) {
        int height = depth(root);
        sum(root,height);
        return s;
    }
}