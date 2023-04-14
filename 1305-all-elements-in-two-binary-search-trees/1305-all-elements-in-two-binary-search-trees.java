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
    List<Integer> al = new ArrayList<>();
    public void inorder(TreeNode root){
        if(root==null)  return;
        inorder(root.left);
        al.add(root.val);
        inorder(root.right);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1);
        inorder(root2);
        Collections.sort(al);
        return al;
    }
}