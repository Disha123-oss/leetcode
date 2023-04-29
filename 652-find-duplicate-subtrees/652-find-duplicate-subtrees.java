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
    public String findduplicate(TreeNode root, List<TreeNode> ans, Map<String,Integer> hm){
        if(root==null) return "&";
        String left = findduplicate(root.left,ans,hm);
        String right = findduplicate(root.right,ans,hm);
        String res = left+","+right+","+root.val;
        if(!hm.containsKey(res))
            hm.put(res,1);
        else{
            if(hm.get(res)==1)
                ans.add(root);
            hm.put(res,2);
        }
        return res;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        Map<String,Integer> hm = new HashMap<>();
        findduplicate(root,ans,hm);
        return ans;
    }
}