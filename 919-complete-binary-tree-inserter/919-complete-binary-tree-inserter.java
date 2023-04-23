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
class CBTInserter {
    TreeNode nip = null;
    TreeNode main = null;
    Queue<TreeNode> q = new LinkedList<>();
    public CBTInserter(TreeNode root) {
        main = root;
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode temp = q.peek();
                if(temp.left!=null){
                    q.add(temp.left);
                }
                else{
                    nip = temp;
                    break;
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                else{
                    nip = temp;
                    break;
                }
                if(temp.left!=null && temp.right!=null)
                    q.poll();
            }
            if(nip!=null)
                break;
        }
    }
    
    public int insert(int val) {
        TreeNode nn = new TreeNode(val);
        TreeNode ans = null;
        if(nip.left==null){
            nip.left=nn;
            ans = nip;
        }
        else{
            nip.right=nn;
            ans=nip;
            q.poll();
            nip=q.peek();
        }
        q.add(nn);
        return ans.val;
    }
    
    public TreeNode get_root() {
        return main;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */