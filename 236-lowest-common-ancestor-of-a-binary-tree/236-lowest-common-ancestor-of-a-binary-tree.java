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
    public void roottoleaf(TreeNode root, TreeNode target, ArrayList<TreeNode> path, ArrayList<TreeNode> res){
        if(root==null) return;
        path.add(root);
        if(root==target){
            for(int i=0;i<path.size();i++){
                res.add(path.get(i));
            }
        }
        roottoleaf(root.left,target,path,res);
        roottoleaf(root.right,target,path,res);
        path.remove(path.size()-1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> al = new ArrayList<>();
        ArrayList<TreeNode> path1 = new ArrayList<>();
        roottoleaf(root,p,al,path1);
        al = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
        roottoleaf(root,q,al,path2);
        int i=0,min=Math.min(path1.size(),path2.size());
        TreeNode ans = null;
        while(i<min){
            if(path1.get(i)!=path2.get(i))
                break;
            ans=path1.get(i);
            i++;
        }
        return ans;
    }
}