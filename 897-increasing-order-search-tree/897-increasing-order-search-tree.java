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
    ArrayList<Integer> al = new ArrayList<>();
    public void inorder(TreeNode root) {
        if(root==null)  return;
        inorder(root.left);
        al.add(root.val);
        inorder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        TreeNode nn = new TreeNode(al.get(0));
        TreeNode dummy = nn;
        TreeNode curr = nn; 
        for(int i=1;i<al.size();i++){
            TreeNode node = new TreeNode(al.get(i));
            curr.right = node;
            curr = curr.right;
        }
        return dummy;
    }
}