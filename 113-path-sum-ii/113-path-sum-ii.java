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
    public void path(TreeNode root, int sum, List<Integer> al, List<List<Integer>> res){
        if(root==null)  return;
        al.add(root.val);
        path(root.left,sum-root.val,al,res);
        path(root.right,sum-root.val,al,res);
        if(root.left==null && root.right==null && sum==root.val){
            res.add(new ArrayList<>(al));
        }
        al.remove(al.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> al = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        path(root,targetSum,al,res);
        return res;
    }
}