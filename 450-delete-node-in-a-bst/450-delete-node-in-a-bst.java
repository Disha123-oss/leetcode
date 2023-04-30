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
    public int max(TreeNode root){
        if(root==null) return 0;
        if(root.right!=null) return max(root.right);
        return root.val;
    }
    public int min(TreeNode root){
        if(root==null) return 0;
        if(root.left!=null) return min(root.left);
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        root.left = deleteNode(root.left,key);
        root.right = deleteNode(root.right,key);
        if(root.val==key){
            if(root.left==null && root.right==null) return null;
            else if(root.left!=null && root.right==null){
                int val = max(root.left);
                root.val = val;
                root.left = deleteNode(root.left,val);
            }
            else{
                int val = min(root.right);
                root.val = val;
                root.right = deleteNode(root.right,val);
            }
        }
        return root;
    }
}