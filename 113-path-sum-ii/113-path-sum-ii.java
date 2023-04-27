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
    public void pathSum(TreeNode root, int targetSum, int sum, List<Integer> path, List<List<Integer>> res) {
        if(root==null) return;
        sum+=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null && sum==targetSum){
            res.add(new ArrayList<>(path));
        }
        pathSum(root.left,targetSum,sum,path,res);
        pathSum(root.right,targetSum,sum,path,res);
        sum-=root.val;
        path.remove(path.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root,targetSum,0,path,res);
        return res;
    }
}