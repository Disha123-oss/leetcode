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
    public boolean check(TreeNode root, long min, long max){
        if(root==null)  return true;
        if(root.val>min && root.val<max){
            boolean left = check(root.left,min,root.val);
            boolean right = check(root.right,root.val,max);
            return left&&right;
        }
        return false;
    }
    public boolean isValidBST(TreeNode root) {
       long min=Long.MIN_VALUE, max=Long.MAX_VALUE;
       return check(root,min,max);
    }
}