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
    public void inorder(TreeNode root, ArrayList<Integer> al){
        if(root==null) return;
        inorder(root.left,al);
        al.add(root.val);
        inorder(root.right,al);
    }
    public TreeNode construct(ArrayList<Integer> al, int s, int e){
        if(s>e)  return null;
        int mid = s+(e-s)/2;
        TreeNode root = new TreeNode(al.get(mid));
        root.left = construct(al,s,mid-1);
        root.right = construct(al,mid+1,e);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        if(root==null)  return null;
        ArrayList<Integer> al = new ArrayList<>();
        inorder(root,al);
        return construct(al,0,al.size()-1);
    }
}