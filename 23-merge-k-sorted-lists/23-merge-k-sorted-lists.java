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
        if(lists.length==0)
            return null;
        ListNode dummy = new ListNode(-1);
        ListNode curr=dummy;
        while(true){
            int p=0;
            for(int i=0;i<lists.length;i++){
                if(lists[p]==null || lists[i]!=null && lists[p].val>lists[i].val)
                    p=i;
            }
            if(lists[p]==null)
                break;
            curr.next=lists[p];
            curr=curr.next;
            lists[p]=lists[p].next;
        }
        return dummy.next;
    }
}