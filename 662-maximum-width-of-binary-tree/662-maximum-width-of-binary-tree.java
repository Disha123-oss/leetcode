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
class Pair{
    TreeNode nn = null;
    int val = 0;
    Pair(TreeNode nn, int val){
        this.nn = nn;
        this.val = val;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxwidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(q.size()>0){
            int size = q.size();
            int index = 0;
            int start = q.peek().val;
            for(int i=0;i<size;i++){
                Pair p = q.remove();
                TreeNode temp = p.nn;
                index = p.val;
                if(temp.left!=null) q.add(new Pair(temp.left,index*2));
                if(temp.right!=null) q.add(new Pair(temp.right,index*2+1));
            }
            maxwidth = Math.max(maxwidth,index-start+1);
        }
        return maxwidth;
    }
}