/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> al = new ArrayList<>();
        if(root==null)  return al;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node temp = q.remove();
                list.add(temp.val);
                for(Node nn : temp.children){
                    q.add(nn);
                }
            }
            al.add(list);
        }
        return al;
    }
}