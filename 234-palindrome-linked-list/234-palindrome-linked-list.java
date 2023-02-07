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
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        int len = 0,k;
        while(curr!=null){
            curr = curr.next;
            len++;
        }
        if(len%2==0){
            k=(len/2)-1;
        }
        else{
            k=len/2;
        }
        curr = head;
        while(k!=0){
            curr = curr.next;
            k--;
        }
        ListNode nn = reverse(curr.next);
        curr.next = nn;
        ListNode start1 = head;
        ListNode start2 = curr.next;
        while(start1!=null && start2!=null){
            if(start1.val!=start2.val)
                return false;
            start1=start1.next;
            start2=start2.next;
        }
        return true;
    }
}