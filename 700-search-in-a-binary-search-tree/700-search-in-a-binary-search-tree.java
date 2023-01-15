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
        boolean ans = false;
        if(root.val<val)
            ans=search(root.right,val);
        else if(root.val>val)
            ans=search(root.left,val);
        else{
            nn=root;
            ans=true;
        }
        return ans;
    }
    public TreeNode searchBST(TreeNode root, int val) {
        boolean ans = search(root,val);
        if(ans==false)  return null;
        return nn;
    }
}