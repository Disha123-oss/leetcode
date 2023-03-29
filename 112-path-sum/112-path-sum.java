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
    public boolean path(TreeNode root, int targetSum, int sum) {
        if(root==null) return false;
        sum+=root.val;
        boolean left = path(root.left,targetSum,sum);
        if(root.left==null && root.right==null){
            if(targetSum==sum)
                return true;
        }
        boolean right = path(root.right,targetSum,sum);
        return left || right;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return path(root,targetSum,0);
    }
}