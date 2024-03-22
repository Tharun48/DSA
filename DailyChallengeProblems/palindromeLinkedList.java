import java.util.*;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    private boolean checkPalindrome(List<Integer> list) {
        int n = list.size();
        for(int i=0;i<n/2;i++) {
            if(list.get(i)!=list.get(n-i-1)) return false;
        }
        return true;
    }
    public ListNode reverseList(ListNode head) {
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
    public boolean isPalindrome(ListNode head) {
        //Approach 1
        // List<Integer> list = new ArrayList<>();
        // while(head!=null) {
        //     list.add(head.val);
        //     head=head.next;
        // }
        // return checkPalindrome(list);
        
        //Approach 2 TC-O(N) SC-O(1)

        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null) {
            slow=slow.next;
            fast=fast.next;
            if(fast!=null)
                fast=fast.next;
        }

        ListNode head1 = reverseList(slow);

        while(head!=null && head1!=null) {
            if(head.val!=head1.val) return false;
            head=head.next;
            head1=head1.next;
        }
        return true;
    }
}