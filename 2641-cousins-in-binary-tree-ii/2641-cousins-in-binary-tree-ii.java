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
    TreeNode node = null;
    TreeNode parent = null;
    Pair(TreeNode node, TreeNode parent){
        this.node = node;
        this.parent = parent;
    }
}
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        List<Integer> al = new ArrayList<>();
        q.add(new Pair(root,null));
        while(q.size()>0){
            int size = q.size();
            List<Pair> list  = new ArrayList<>();
            int sum=0;
            for(int i=0;i<size;i++){
                Pair nn = q.remove();
                TreeNode temp = nn.node;
                TreeNode parent = nn.parent;
                list.add(new Pair(temp,parent));
                sum+=temp.val;
                if(temp.left!=null) q.add(new Pair(temp.left,temp));
                if(temp.right!=null) q.add(new Pair(temp.right,temp));
            }
            for(Pair p : list){
                TreeNode node = p.node;
                TreeNode parent = p.parent;
                int sub = 0;
                if(parent==null){
                    node.val=0;
                    continue;
                }
                if(parent.left!=null) sub+=parent.left.val;
                if(parent.right!=null) sub+=parent.right.val;
                al.add(sum-sub);
            }
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int j=0;
        System.out.print(al.size());
        while(que.size()>0){
            int size = que.size();
            for(int i=0;i<size;i++){
                TreeNode temp = que.remove();
                if(temp!=root)
                    temp.val = al.get(j++);
                if(temp.left!=null) que.add(temp.left);
                if(temp.right!=null) que.add(temp.right);
            }
        }
        return root;
    }
}