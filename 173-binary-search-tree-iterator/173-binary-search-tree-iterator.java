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
class BSTIterator {
    Stack<TreeNode> st = null;
    TreeNode curr = null;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        curr = root;
    }
    
    public int next() {
        while(curr!=null){
            st.push(curr);
            curr = curr.left;
        }
        TreeNode nn = st.pop();
        curr = nn.right;
        return nn.val;
    }
    
    public boolean hasNext() {
        return st.size()>0 || curr!=null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */