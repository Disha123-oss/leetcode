/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr=node;
        int temp = curr.next.val;
        curr.val=temp;
        curr.next=curr.next.next;
    }
}