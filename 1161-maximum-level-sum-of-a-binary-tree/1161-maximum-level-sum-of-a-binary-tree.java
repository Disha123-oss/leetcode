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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level=0;
        int max=Integer.MIN_VALUE, ans=0;
        while(q.size()>0){
            int size = q.size();
            int sum=0;
            level++;
            for(int i=0;i<size;i++){
                TreeNode temp = q.remove();
                sum+=temp.val;
                if(temp.left!=null)  q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            if(max<sum){
                max=sum;
                ans=level;
            }
        }
        return ans;
    }
}