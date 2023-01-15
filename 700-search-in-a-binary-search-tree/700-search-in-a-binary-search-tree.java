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
    TreeNode nn;
    public boolean search(TreeNode root, int val) {
        if(root==null) return false;
        boolean left = search(root.left,val);
        boolean right = search(root.right,val);
        if(left==false && right==false){
            if(root.val==val){
                nn = root;
                return true;
            }
        }
        return left||right;
    }
    public TreeNode searchBST(TreeNode root, int val) {
        boolean ans = search(root,val);
        if(ans==false)  return null;
        return nn;
    }
}