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
    public int[] max(TreeNode root){
        if(root==null) return new int[]{0,0};
        int[] left = max(root.left);
        int[] right = max(root.right);
        int include = left[1]+right[1]+root.val;
        int include_not = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return new int[]{include,include_not};
    }
    public int rob(TreeNode root) {
        int[] ans = max(root);
        return Math.max(ans[0],ans[1]);
    }
}