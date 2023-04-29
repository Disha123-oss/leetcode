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
    int min=0;
    public void roottotarget(TreeNode root, int target, ArrayList<TreeNode> path, ArrayList<TreeNode> res){
        if(root==null) return;
        path.add(root);
        if(root.val==target){
            for(int i=0;i<path.size();i++){
                res.add(path.get(i));
            }
        }
        roottotarget(root.left,target,path,res);
        roottotarget(root.right,target,path,res);
        path.remove(path.size()-1);
    }
    public void knodesdown(TreeNode root, int t, TreeNode blocker){
        if(root==null || root==blocker) return;
        min=Math.max(min,t);
        knodesdown(root.left,t+1,blocker);
        knodesdown(root.right,t+1,blocker);
    }
    public int amountOfTime(TreeNode root, int start) {
        ArrayList<TreeNode> path = new ArrayList<>();
        ArrayList<TreeNode> res = new ArrayList<>();
        roottotarget(root,start,path,res);
        int time=0;
        for(int i=res.size()-1;i>=0;i--){
            knodesdown(res.get(i),time,(i==res.size()-1)?null:res.get(i+1));
            time++;
        }
        return min;
    }
}