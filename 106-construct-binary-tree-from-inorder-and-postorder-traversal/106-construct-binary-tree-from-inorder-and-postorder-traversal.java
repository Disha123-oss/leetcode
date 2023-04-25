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
    public TreeNode build(int[] postorder, int[] inorder,Map<Integer,Integer> hm, int s, int e, int ps, int pe){
        if(s>e) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ind = hm.get(postorder[pe]);
        int tot = ind-s;
        root.left = build(postorder,inorder,hm,s,ind-1,ps,ps+tot-1);
        root.right = build(postorder,inorder,hm,ind+1,e,ps+tot,pe-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return build(postorder,inorder,hm,0,inorder.length-1,0,postorder.length-1);
    }
}