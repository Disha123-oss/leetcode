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
    static int mod = (int)(1e9+7);
    long max=0;
    public int sum(TreeNode root){
        if(root==null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        return left+right+root.val;
    }
    public long product(TreeNode root, long sum){
        if(root==null) return 0;
        long left = product(root.left,sum);
        long right = product(root.right,sum);
        long sum1 = left+right+root.val;
        long sum2 = sum-sum1;
        max = Math.max(max,sum1*sum2);
        return sum1;
    }
    public int maxProduct(TreeNode root) {
        long sum = sum(root);
        product(root,sum);
        return (int)(max%(Math.pow(10,9)+7));
    }
}