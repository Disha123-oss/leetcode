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
    public ListNode rotateRight(ListNode head, int k) {
       if(head==null || head.next==null)
			return head;
		ListNode curr = head;
		int count=0;
		while(curr!=null){
			curr=curr.next;
			count++;
		}
		int num=0;
		if(count==k)
			return head;
		if(count>k)
			num = (count-k-1)%count;
		else if(count<k)
			num = count-(k%count)-1;
		curr=head;
		while(num>0){
			curr=curr.next;
			num--;
		}
		ListNode p2 = curr.next;
		ListNode h = p2;
		curr.next=null;
		while(p2!=null && p2.next!=null){
			p2=p2.next;
		}
        if(p2!=null){
            p2.next=head;
            head=h;
        }
		return head;
    }
}