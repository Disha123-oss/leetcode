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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            List<Integer> al = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = q.remove();
                al.add(temp.val);
                if(temp.left!=null)  q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            list.add(al);
        }
        List<Integer> lastrow = list.get(list.size()-1);
        return lastrow.get(0);
    }
}