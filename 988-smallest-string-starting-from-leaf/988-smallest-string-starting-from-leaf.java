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
    public void path(TreeNode root, String s, List<String> al){
        if(root==null) return;
        char ch = (char)('a'+root.val);
        s+=ch;
        if(root.left==null && root.right==null){
            String str = "";
            for(int i=s.length()-1;i>=0;i--){
                str+=s.charAt(i);
            }
            al.add(str);
        }
        path(root.left,s,al);
        path(root.right,s,al);
    }
    public String smallestFromLeaf(TreeNode root) {
        List<String> al = new ArrayList<>();
        path(root,"",al);
        Collections.sort(al);
        return al.get(0);
    }
}