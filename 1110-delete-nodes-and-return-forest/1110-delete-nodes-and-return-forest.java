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
    List<TreeNode> ans = new ArrayList<>();
    public TreeNode delete(TreeNode root, Set<Integer> hs){
        if(root==null) return null;
        root.left = delete(root.left,hs);
        root.right = delete(root.right,hs);
        if(hs.contains(root.val)){
            if(root.left==null && root.right==null)
                return null;
            else{
                if(root.left!=null)  ans.add(root.left);
                if(root.right!=null) ans.add(root.right);
                return null;
            }
        }
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root==null) return null;
        Set<Integer> hs = new HashSet<>();
        for(int val : to_delete){
            hs.add(val);
        }
        delete(root, hs);
        if(root!=null && !hs.contains(root.val))  ans.add(root);
        return ans;
    }
}