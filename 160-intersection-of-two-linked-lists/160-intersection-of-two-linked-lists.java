/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        int len1=0,len2=0,k;
        while(curr!=null){
            curr=curr.next;
            len1++;
        }
        curr=headB;
        while(curr!=null){
            curr=curr.next;
            len2++;
        }
        ListNode curr1=headA;
        ListNode curr2=headB;
        if(len1>len2){
            k=len1-len2;
            while(k!=0){
                curr1=curr1.next;
                k--;
            }
        }
        else if(len2>len1){
            k=len2-len1;   
            while(k!=0){
                curr2=curr2.next;
                k--;
            }
        }
        while(curr1!=null || curr2!=null){
            if(curr1==curr2)
                return curr1;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return null;
    }
}