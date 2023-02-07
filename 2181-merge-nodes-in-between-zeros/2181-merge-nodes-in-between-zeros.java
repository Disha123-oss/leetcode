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
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode nn = dummy;
        int sum=0;
        ListNode curr = head.next;
        while(curr!=null){
            sum+=curr.val;
            if(curr.val==0){
                ListNode node = new ListNode(sum);
                nn.next = node;
                nn=nn.next;
                sum=0;
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}