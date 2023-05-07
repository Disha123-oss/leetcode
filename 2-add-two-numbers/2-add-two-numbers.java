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
    public ListNode reverse(ListNode root){
		ListNode prev = null, curr = root, next = null;
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	public ListNode addTwoNumbers(ListNode first, ListNode second) {
		// Write your code here.
		ListNode l1 = first;
		ListNode l2 = second;
		int carry = 0, total=0;
		ListNode temp = new ListNode(-1);
		ListNode curr = temp;
		while(l1!=null || l2!=null || carry!=0){
			if(l1!=null && l2!=null){
				total = l1.val+l2.val+carry;
			}
			else if(l1!=null){
				total = l1.val+carry;
			}
			else if(l2!=null){
				total = l2.val+carry;
			}
			else{
				total = carry;
			}
			carry = total/10;
			ListNode nn = new ListNode();
			nn.val = total%10;
			curr.next = nn;
			curr = curr.next;
			if(l1!=null) l1 = l1.next;
			if(l2!=null) l2 = l2.next;
		}
		return temp.next;
	}
}