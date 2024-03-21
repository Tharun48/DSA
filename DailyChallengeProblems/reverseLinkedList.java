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
    public ListNode reverseList(ListNode head) {
        // Approach 1
        // TC - O(2*N)
        // SC - O(N)
        // ListNode temp=head;
        // if(temp==null) return null;
        // List<Integer> list = new ArrayList<>();
        // while(temp!=null) {
        //     list.add(temp.val);
        //     temp=temp.next;
        // }
        
        // Collections.reverse(list);

        // ListNode dummyHead=head;
        // while(head!=null) {
        //     head.val=list.get(0);
        //     list.remove(0);
        //     head=head.next;
        // }
        // return dummyHead;

        // Approach 2
        // TC - O(2*N)
        // SC - O(1)
        ListNode cur = head;
        ListNode prev=null;
        ListNode next=null;
        while(cur!=null) {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}