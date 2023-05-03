/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean path(TreeNode root, String path, String str){
        if(root==null) return false;
        path+=root.val;
        if(path.equals(str)) return true;
        boolean left = path(root.left,path,str);
        boolean right = path(root.right,path,str);
        return left || right;
    }
    public boolean preorder(TreeNode root,String path, String str){
       if(root==null) return false;
       boolean ans = path(root,path,str);
       boolean left = preorder(root.left,path,str);
       boolean right = preorder(root.right,path,str);
       return ans || left || right;
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        ListNode curr = head;
        String str = "";
        while(curr!=null){
            str+=curr.val;
            curr = curr.next;
        }
        return preorder(root,"",str);
    }
}