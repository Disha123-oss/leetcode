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
    int maxdiff=0;
    public int[] maxdiff(TreeNode root){
        if(root==null){
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        }
        int[] left = maxdiff(root.left);
        int[] right = maxdiff(root.right);
        
        int leftmin = left[0];
        int rightmin = right[0];
        int min = Math.min(root.val,Math.min(leftmin,rightmin));
        
        int leftmax = left[1];
        int rightmax = right[1];
        int max = Math.max(root.val,Math.max(leftmax,rightmax));
        
        maxdiff = Math.max(maxdiff,Math.max(root.val-min,max-root.val));
        
        return new int[]{min,max};
    }
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) return 0;
        maxdiff(root);
        return maxdiff;
    }
}