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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        int level=1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode temp = q.remove();
                if(depth==1){
                    TreeNode left = temp;
                    TreeNode nn = new TreeNode(val);
                    nn.left = left;
                    return nn;
                }
                if(depth>1 && level==depth-1){
                    TreeNode left = temp.left;
                    TreeNode right = temp.right;
                    TreeNode n1 = new TreeNode(val);
                    TreeNode n2 = new TreeNode(val);
                    temp.left = n1;
                    temp.right = n2;
                    n1.left = left;
                    n2.right = right;
                    
                }
                if(level<depth-1 && temp.left!=null) q.add(temp.left);
                if(level<depth-1 && temp.right!=null) q.add(temp.right);
            }
            level++;
        }
        return root;
    }
}