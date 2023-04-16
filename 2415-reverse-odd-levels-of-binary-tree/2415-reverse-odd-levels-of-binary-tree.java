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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level=0;
        while(q.size()>0){
            int size = q.size();
            ArrayList<TreeNode> list = new ArrayList<>(); 
            ArrayList<Integer> al = new ArrayList<>(); 
            for(int i=0;i<size;i++){
                TreeNode temp = q.remove();
                if(level%2!=0)  list.add(temp);
                if(level%2!=0)  al.add(temp.val);
                if(temp.left!=null)  q.add(temp.left);
                if(temp.right!=null)  q.add(temp.right);
            }
            int j=al.size()-1;
            for(TreeNode node : list){
                node.val = al.get(j--);
            }
            level++;
        }
        return root;
    }
}