/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head, fast=head;
        if(head==null || head.next==null)
            return null;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                break;
        }
        slow=head;
        while(fast!=null && fast.next!=null && slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        if(slow==fast)
            return slow;
        else
            return null;
    }
}