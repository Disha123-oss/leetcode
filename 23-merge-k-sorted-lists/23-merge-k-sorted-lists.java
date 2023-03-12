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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);

        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) ->(o1.val - o2.val));
        for (ListNode root : lists)
            if (root != null)
                pq.offer(root);
                
        ListNode ptr = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            ptr.next = curr;
            ptr = ptr.next;

            if (curr.next != null) pq.offer(curr.next);
        }
        return dummy.next;
    }
}