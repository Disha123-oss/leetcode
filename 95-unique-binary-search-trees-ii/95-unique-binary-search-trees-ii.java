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
    public List<TreeNode> generateTrees(int l, int h){
        List<TreeNode> nn = new ArrayList<>();
        if(l>h){
            nn.add(null);
            return nn;
        }
        for(int i=l;i<=h;i++){
            List<TreeNode> left = generateTrees(l,i-1);
            List<TreeNode> right = generateTrees(i+1,h);
            for(TreeNode lr : left){
                for(TreeNode rr : right){
                    TreeNode root = new TreeNode(i);
                    root.left = lr;
                    root.right = rr;
                    nn.add(root);
                }
            }
        }
        return nn;
    }
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }
}