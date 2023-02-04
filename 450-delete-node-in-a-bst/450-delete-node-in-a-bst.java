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
    public int min(TreeNode root){
        if(root==null)  return 0;
        if(root.left!=null)  return min(root.left);
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)  return null;
        if(root.val<key)  root.right=deleteNode(root.right,key);
        else if(root.val>key)   root.left=deleteNode(root.left,key);
        else{
            if(root.left==null && root.right==null)
                return null;
            else if(root.left==null && root.right!=null)
                return root.right;
            else if(root.left!=null && root.right==null)
                return root.left;
            else{
                root.val = min(root.right);
                root.right=deleteNode(root.right,root.val);
            }
        }
        return root;
    }
}