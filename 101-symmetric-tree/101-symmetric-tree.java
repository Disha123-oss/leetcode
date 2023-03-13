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
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null&&root.right==null) return true;
        return checkSymetric(root.left,root.right);    
    }
    private boolean checkSymetric(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null) return true;
        if(node1!=null&&node2==null||node1==null&&node2!=null) return false;
        if(node1.val!=node2.val) return false;
        return checkSymetric(node1.left,node2.right)&&checkSymetric(node1.right,node2.left);
    }
}