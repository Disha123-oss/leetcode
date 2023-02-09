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
    public ListNode reverse(ListNode head){
        ListNode curr = head, prev=null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode curr = head;
        int len=0, i=0, max=0;
        while(curr!=null){
            curr = curr.next;
            len++;
        }
        int k = (len/2) - 1;
        curr = head;
        while(i!=k){
            curr = curr.next;
            i++;
        }
        ListNode nn = reverse(curr.next);
        curr.next = nn;
        ListNode l1 = head, l2 = nn;
        while(l2!=null){
            int sum = l1.val + l2.val;
            max = Math.max(max,sum);
            l1 = l1.next;
            l2 = l2.next;
        }
        return max;
    }
}