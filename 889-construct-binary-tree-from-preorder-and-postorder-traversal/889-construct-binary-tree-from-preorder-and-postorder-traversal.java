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
    int preindex=0;
    public TreeNode helper(int[] preorder, int[] postorder, HashMap<Integer,Integer> hm, int start, int end){
        if(start>end) return null;
        TreeNode root = new TreeNode(preorder[preindex++]);
        if(start==end)  return root;
        int index = hm.get(preorder[preindex]);
        root.left = helper(preorder,postorder,hm,start,index);
        root.right = helper(preorder,postorder,hm,index+1,end-1);
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            hm.put(postorder[i],i);
        }
        return helper(preorder,postorder,hm,0,preorder.length-1);
    }
}