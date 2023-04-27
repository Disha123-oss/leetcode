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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.peek()!=null){
            TreeNode temp = q.remove();
            q.add(temp.left);
            q.add(temp.right);
        }
        while(q.size()>0 && q.peek()==null){
            q.remove();
        }
        return q.size()==0;
    }
}