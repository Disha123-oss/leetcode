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
    public int length(ListNode head){
        ListNode curr = head;
        int len=0;
        while(curr!=null){
            curr = curr.next;
            len++;
        }
        return len;
    }
    public TreeNode bst(int[] arr, int s, int e) {
        if(s>e) return null;
        int mid = (s+e)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = bst(arr,s,mid-1);
        root.right = bst(arr,mid+1,e);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        int len = length(head);
        int[] arr = new int[len];
        ListNode curr = head;
        int i=0;
        while(curr!=null){
            arr[i++] = curr.val;
            curr = curr.next;
        }
        return bst(arr,0,len-1);
    }
}