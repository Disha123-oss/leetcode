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
    public void roottoleaf(TreeNode root, String s, List<String> res){
        if(root==null)  return;
        s+=Integer.toString(root.val);
        roottoleaf(root.left,s,res);
        roottoleaf(root.right,s,res);
        if(root.left==null && root.right==null){
            res.add(s);
        }
    }
    public int sumNumbers(TreeNode root) {
        List<String> res = new ArrayList<>();
        roottoleaf(root,"",res);
        int ans = 0;
        for(int i=0;i<res.size();i++){
            ans += Integer.valueOf(res.get(i));
        }
        return ans;
    }
}