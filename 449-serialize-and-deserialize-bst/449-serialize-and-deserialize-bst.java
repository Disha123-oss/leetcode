/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public void serialize(TreeNode root, StringBuilder sb) {
        if(root==null){
            sb.append("x,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        serialize(root.left,sb);
        serialize(root.right,sb);
    }
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(Deque<String> dq){
        String s = dq.remove();
        if(s.equals("x")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(dq);
        root.right = deserialize(dq);
        return root;
    }
    public TreeNode deserialize(String data) {
        Deque<String> dq = new LinkedList<>();
        dq.addAll(Arrays.asList(data.split(",")));
        return deserialize(dq);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;