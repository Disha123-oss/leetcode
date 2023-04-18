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
    int count=0;
    public int distribute(TreeNode root) {
        if(root==null) return 0;
        int left = distribute(root.left);
        int right = distribute(root.right);
        root.val=root.val+left+right;
        count=count+Math.abs(left)+Math.abs(right);
        if(root.val<1){
            int needed = 1+Math.abs(root.val);
            root.val=1;
            return (-1)*needed;
        }
        if(root.val>1){
            int extra = root.val-1;
            root.val=1;
            return extra;
        }
        return 0;
    }
    public int distributeCoins(TreeNode root) {
        if(root==null) return 0;
        distribute(root);
        return count;
    }
}