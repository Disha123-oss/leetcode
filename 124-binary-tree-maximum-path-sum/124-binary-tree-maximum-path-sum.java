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
    public int maxPathSum(TreeNode root) {
        liner(root);
        return maxPathSum2(root);
    }
    public int maxPathSum2(TreeNode root) {
        int lefter = root.left == null ? 0 : root.left.val;
        int righter = root.right == null ? 0 : root.right.val;
        int minBranch = Math.min(lefter, righter);
        int current = Math.max(root.val, root.val + minBranch);

        int best = current;
        if(root.left != null)
            best = Math.max(best, maxPathSum2(root.left));
        if(root.right != null)
            best = Math.max(best, maxPathSum2(root.right));
        return  best;
    }
    public int liner(TreeNode root){
        if(root == null) return 0;
        int max = Math.max(root.val, liner(root.left) + root.val);
        max = Math.max(max, liner(root.right) + root.val);
        root.val = max;
        return max;
    }
}