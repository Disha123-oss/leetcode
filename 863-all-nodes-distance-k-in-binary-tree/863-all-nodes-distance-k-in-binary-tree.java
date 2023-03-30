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
    public void roottotarget(TreeNode root, TreeNode target, List<TreeNode> al, List<TreeNode> res){
        if(root==null) return;
        al.add(root);
        if(root==target){
            for(int i=0;i<al.size();i++){
                res.add(al.get(i));
            }
        }
        roottotarget(root.left,target,al,res);
        roottotarget(root.right,target,al,res);
        al.remove(al.size()-1);
    }
    public void knodesdown(TreeNode root, int k, TreeNode blocker, List<Integer> al){
        if(root==null || k<0 || root==blocker) return;
        if(k==0) al.add(root.val);
        knodesdown(root.left,k-1,blocker,al);
        knodesdown(root.right,k-1,blocker,al);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> al = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        roottotarget(root,target,al,path);
        Collections.reverse(path);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<path.size();i++){
            knodesdown(path.get(i),k-i,i==0 ? null:path.get(i-1),list);
        }
        return list;
    }
}