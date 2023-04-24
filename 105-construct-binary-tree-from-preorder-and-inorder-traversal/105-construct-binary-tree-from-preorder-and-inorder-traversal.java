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
    int i=0;
    public TreeNode build(int[] preorder, Map<Integer,Integer> hm, int s, int e) {
        if(s>e) return null;
        TreeNode root = new TreeNode(preorder[i]);
        int ind = hm.get(preorder[i++]);
        root.left = build(preorder,hm,s,ind-1);
        root.right = build(preorder,hm,ind+1,e);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       Map<Integer,Integer> hm = new HashMap<>();
       for(int i=0;i<inorder.length;i++){
           hm.put(inorder[i],i);
       }
       return build(preorder,hm,0,inorder.length-1);
    }
}