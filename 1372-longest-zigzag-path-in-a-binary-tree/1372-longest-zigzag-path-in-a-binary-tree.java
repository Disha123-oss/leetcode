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
class Pair{
    int forwardslop=-1;
    int backwardslop=-1;
    int maxlen=0;
}
class Solution {
    public Pair longestzigzag(TreeNode root){
        if(root==null) return new Pair();
        Pair left = longestzigzag(root.left);
        Pair right = longestzigzag(root.right);
        Pair ans = new Pair();
        ans.forwardslop = left.backwardslop+1;
        ans.backwardslop = right.forwardslop+1;
        ans.maxlen = Math.max(Math.max(left.maxlen,right.maxlen),Math.max(left.backwardslop,right.forwardslop)+1);
        return ans;
    }
    public int longestZigZag(TreeNode root) {
        Pair ans = longestzigzag(root);
        return ans.maxlen;
    }
}