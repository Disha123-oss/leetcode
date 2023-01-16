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
    int count=1;
    int max=0;
    TreeNode prev = null;
    public void inorder(TreeNode root, List<TreeNode> list){
        if(root==null)  return;
        inorder(root.left,list);
        if(prev!=null){
            if(prev.val==root.val){
                count++;
            }
            else{
                count=1;
            }
        }
        if(count>max){
            list.clear();
            list.add(root);
            max=count;
        }
        else if(count==max){
            list.add(root);
        }
        prev=root;
        inorder(root.right,list);
    }
    public int[] findMode(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root,list);
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i).val;
        }
        return arr;
    }
}