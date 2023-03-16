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
    int postindex=0;
    TreeNode tree(int post[],int in[],int is,int ie)
    {
        if(is>ie)
        {
            return null;
        }
        TreeNode root=new TreeNode(post[postindex--]);
        
        int inindex=0;
        for(int i=is;i<=ie;i++)
        {
            if(in[i]==root.val)
            {
                inindex=i;
                break;
            }
        }
        root.right=tree(post,in,inindex+1,ie);
        root.left=tree(post,in,is,inindex-1);
        
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
           postindex=postorder.length-1;
           return tree(postorder,inorder,0,inorder.length-1);
    }
}