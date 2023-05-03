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
    int max = 0;
    public int path(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        int left = path(root.left);
        int right = path(root.right);
        int leftcheck=0, rightcheck=0;
        if(root.left!=null && root.val==root.left.val) leftcheck=left+1;
        if(root.right!=null && root.val==root.right.val) rightcheck=right+1;
        max = Math.max(max,leftcheck+rightcheck);
        return Math.max(leftcheck,rightcheck);
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        path(root);
        return max;
    }
}