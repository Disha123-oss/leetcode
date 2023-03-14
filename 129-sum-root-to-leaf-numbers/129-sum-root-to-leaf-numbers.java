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
    public int sumNumbers(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans,0);
        int ret = 0;
        for(int i=0; i<ans.size(); i++){
            ret+=ans.get(i);
        }
        return ret;
    }
    void dfs(TreeNode root, List<Integer> mid, int temp){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            mid.add(temp*10 + root.val);
        }
        dfs(root.left,mid,temp*10 + root.val);
        dfs(root.right,mid,temp*10 + root.val);
    }
}