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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level=0;
        boolean ans = true;
        while(q.size()>0){
            int size = q.size();
            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                TreeNode temp = q.remove();
                if(level%2==0){
                    if(temp.val>min){
                        min = temp.val;
                    }
                    else{
                        ans=false;
                        break;
                    }
                    if(temp.val%2==0){
                        ans=false;
                        break;
                    }
                }
                else{
                    if(temp.val<max){
                        max = temp.val;
                    }
                    else{
                        ans=false;
                        break;
                    }
                    if(temp.val%2!=0){
                        ans=false;
                        break;
                    }
                }
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            if(ans==false) break;
            level++;
        }
        return ans;
    }
}