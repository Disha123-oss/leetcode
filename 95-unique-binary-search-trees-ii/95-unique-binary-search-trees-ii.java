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
    public List<TreeNode> generate(int l, int h) {
        List<TreeNode> ans = new ArrayList<>();
        if(l>h){
            ans.add(null);
            return ans;
        }
        for(int i=l;i<=h;i++){
            List<TreeNode> left = generate(l,i-1);
            List<TreeNode> right = generate(i+1,h);
            for(TreeNode lt : left){
                for(TreeNode rt : right){
                    TreeNode root = new TreeNode(i);
                    root.left = lt;
                    root.right = rt;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
    public List<TreeNode> generateTrees(int n) {
       return generate(1,n);
    }
}