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
    List<Integer> al = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public void path(TreeNode root, int targetSum){
      if(root==null)
         return;
      al.add(root.val);
      targetSum-=root.val;
      if(targetSum==0 && root.left==null && root.right==null){
          ArrayList<Integer> temp = new ArrayList<>(al);
          res.add(temp);
      }
      path(root.left,targetSum);
      path(root.right,targetSum);
      al.remove(al.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        path(root,targetSum);
        return res;
    }
}