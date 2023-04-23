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
    List<Integer> al = new ArrayList<>();
    public void knodesdown(TreeNode root, TreeNode blocker, int k){
        if(root==null || root==blocker || k<0) return;
        knodesdown(root.left,blocker,k-1);
        knodesdown(root.right,blocker,k-1);
        if(k==0) al.add(root.val);
    }
    public void roottoleaf(TreeNode root, TreeNode target, List<TreeNode> path, List<TreeNode> list){
        if(root==null) return;
        path.add(root);
        if(root==target){
            for(int i=0;i<path.size();i++){
                list.add(path.get(i));
            }
        }
        roottoleaf(root.left,target,path,list);
        roottoleaf(root.right,target,path,list);
        path.remove(path.size()-1);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null) return al;
        List<TreeNode> path = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        roottoleaf(root,target,path,list);
        for(int i=list.size()-1;i>=0;i--){
            knodesdown(list.get(i),(i==list.size()-1)?null:list.get(i+1),k);
            k--;
        }
        return al;
    }
}