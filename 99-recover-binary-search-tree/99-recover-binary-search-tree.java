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
    public void inorder(TreeNode root, List<TreeNode> al){
        if(root==null) return;
        inorder(root.left,al);
        al.add(root);
        inorder(root.right,al);
    }
    public void recoverTree(TreeNode root) {
        List<TreeNode> al = new ArrayList<>();
        inorder(root,al);
        TreeNode first=null,second=null,third=null;
        for(int i=0;i<al.size()-1;i++){
            if(al.get(i).val>al.get(i+1).val && first==null){
                first=al.get(i);
                second=al.get(i+1);
            }
            else if(al.get(i).val>al.get(i+1).val && first!=null){
                third=al.get(i+1);
            }
        }
        if(third!=null){
            int temp = first.val;
            first.val = third.val;
            third.val = temp;
        }
        else{
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}