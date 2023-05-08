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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                ListNode nn = new ListNode(list1.val);
                curr.next = nn;
                curr = curr.next;
                list1 = list1.next;
            }
            else{
                ListNode nn = new ListNode(list2.val);
                curr.next = nn;
                curr = curr.next;
                list2 = list2.next;
            }
        }
        while(list1!=null){
            ListNode nn = new ListNode(list1.val);
            curr.next = nn;
            curr = curr.next;
            list1 = list1.next;
        }
         while(list2!=null){
            ListNode nn = new ListNode(list2.val);
            curr.next = nn;
            curr = curr.next;
            list2 = list2.next;
        }
        return dummy.next;
    }
}