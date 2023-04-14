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
   
    public void inorder(TreeNode root, List<Integer> al){
        if(root==null)  return;
        inorder(root.left,al);
        al.add(root.val);
        inorder(root.right,al);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();
        List<Integer> al3 = new ArrayList<>();
        inorder(root1,al1);
        inorder(root2,al2);
        //merge two sorted lists
        int i=0,j=0;
        while(i<al1.size() && j<al2.size()){
            if(al1.get(i)<=al2.get(j)){
                al3.add(al1.get(i));
                i++;
            }
            else if(al1.get(i)>al2.get(j)){
                al3.add(al2.get(j));
                j++;
            }
        }
        while(i<al1.size()){
            al3.add(al1.get(i));
            i++;
        }
        while(j<al2.size()){
            al3.add(al2.get(j));
            j++;
        }
        return al3;
    }
}