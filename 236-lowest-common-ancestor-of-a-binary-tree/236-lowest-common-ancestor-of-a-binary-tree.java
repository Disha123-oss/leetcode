/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void path(TreeNode root, int target, List<TreeNode> al, List<TreeNode> res){
        if(root==null)  return;
        al.add(root);
        if(root.val==target){
            for(int i=0;i<al.size();i++){
                res.add(al.get(i));
            }
        }
        path(root.left,target,al,res);
        path(root.right,target,al,res);
        al.remove(al.size()-1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> al = new ArrayList<>();
        List<TreeNode> res1 = new ArrayList<>();
        path(root,p.val,al,res1);
        al = new ArrayList<>();
        List<TreeNode> res2 = new ArrayList<>();
        path(root,q.val,al,res2);
        int min = Math.min(res1.size(),res2.size());
        TreeNode ans=null;
        for(int i=0;i<min;i++){
            if(res1.get(i)==res2.get(i))
                ans=res1.get(i);
        }
        return ans;
    }
}