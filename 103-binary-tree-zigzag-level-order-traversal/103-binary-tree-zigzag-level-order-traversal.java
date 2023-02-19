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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            List<List<Integer>> al = new ArrayList<>();
            return al;
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level=0;
        while(q.size()>0){
            List<Integer> al = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode temp = q.remove();
                al.add(temp.val);
                if(temp.left!=null)   q.add(temp.left);
                if(temp.right!=null)  q.add(temp.right);
            }
            level++;
            if(level%2!=0){
                list.add(al);
            }
            else{
                Collections.reverse(al);
                list.add(al);
            }
        }
        return list;
    }
}