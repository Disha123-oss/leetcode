/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Stack<TreeNode> st = new Stack<>();
    public ArrayList<TreeNode> lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            ArrayList<TreeNode> base = new ArrayList<>();
            return base;
        }
        boolean foundp=false, foundq=false;
        ArrayList<TreeNode> al = new ArrayList<>();
        ArrayList<TreeNode> left = lca(root.left,p,q);
        ArrayList<TreeNode> right = lca(root.right,p,q);
        for(int i=0;i<left.size();i++)
            al.add(left.get(i));
        for(int i=0;i<right.size();i++)
            al.add(right.get(i));
        al.add(root);
        for(int i=0;i<al.size();i++){
            if(al.get(i).val==p.val)
                foundp=true;
            if(al.get(i).val==q.val)
                foundq=true;
        }
        if(foundp==true && foundq==true){
            if(st.size()==0)
                st.push(al.get(al.size()-1));
            return al;
        }
        return al;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> al = new ArrayList<>();
        ArrayList<TreeNode> list = lca(root,p,q);
        return st.pop();
    }
}