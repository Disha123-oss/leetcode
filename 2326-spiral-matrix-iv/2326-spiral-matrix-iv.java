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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr = new int[m][n];
        for(int[] row : arr)
            Arrays.fill(row,-1);
        ListNode curr = head;
        int top=0, left=0, right=n-1, bottom=m-1, dir=1;
        while(curr!=null){
            if(dir==1 && curr!=null){
                for(int i=left;i<=right;i++){
                    arr[top][i] = curr.val;
                    curr = curr.next;
                    if(curr==null) break;
                }
                ++top;
                dir=2;
                
            }
            else if(dir==2 && curr!=null){
                for(int i=top;i<=bottom;i++){
                    arr[i][right] = curr.val;
                    curr = curr.next;
                    if(curr==null) break;
                }
                --right;
                dir=3;
                
            }
            else if(dir==3 && curr!=null){
                for(int i=right;i>=left;i--){
                    arr[bottom][i] = curr.val;
                    curr = curr.next;
                    if(curr==null) break;
                }
                --bottom;
                dir=4;
            }
            else if(dir==4 && curr!=null){
                for(int i=bottom;i>=top;i--){
                    arr[i][left] = curr.val;
                    curr = curr.next;
                    if(curr==null) break;
                }
                ++left;
                dir=1;
            }
        }
        return arr;
    }
}