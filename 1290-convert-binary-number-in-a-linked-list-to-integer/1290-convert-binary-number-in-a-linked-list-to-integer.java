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
    public int getDecimalValue(ListNode head) {
        ListNode curr=head;
        int len=0;
        while(curr.next!=null){
           curr=curr.next;
            len++;
        }
        curr=head;
        int ans=0;
        while(curr!=null){
            if(curr.val==1)
                ans+=(int)Math.pow(2,len);
            len--;
            curr=curr.next;
        }
        return ans;
    }
}