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
    public boolean validbst(TreeNode root, long min, long max){
        if(root==null) return true;
        boolean left = validbst(root.left,min,root.val);
        boolean right = validbst(root.right,root.val,max);
        boolean ans = false;
        if(root.val>min && root.val<max) ans = true;
        return left && right && ans;
    }
    public boolean isValidBST(TreeNode root) {
        return validbst(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}