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
    public void knodesdown(TreeNode root, int k){
        if(root==null)  return;
        if(k<0)  return;
        if(k==0){
            al.add(root.val);
            return;
        }
        knodesdown(root.left,k-1);
        knodesdown(root.right,k-1);
    }
    public void sum(TreeNode root){
        if(root==null)  return;
        sum(root.left);
        if(root.val%2==0){
            knodesdown(root,2);
        }
        sum(root.right);
    }
    public int sumEvenGrandparent(TreeNode root) {
        sum(root);
        int sum=0;
        for(int i=0;i<al.size();i++){
            sum+=al.get(i);
        }
        return sum;
    }
}