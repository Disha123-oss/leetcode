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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1;
        int i=0;
        while(i!=a-1){
            curr = curr.next;
            i++;
        }
        ListNode start = curr;
        while(i!=b){
            curr.next = curr.next.next;
            i++;
        }
        ListNode end = curr.next;
        start.next = list2;
        curr = list2;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.next = end;
        return list1;
    }
}