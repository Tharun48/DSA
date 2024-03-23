class Solution {
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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null) {
            slow=slow.next;
            fast=fast.next;
            if(fast!=null)
                fast=fast.next;
        }

        ListNode second = reverseList(slow.next);
        slow.next=null;

        ListNode first=head;

        while(second!=null) {
            ListNode temp1 = first.next;
            first.next=second;
            first=temp1;
            ListNode temp2=second.next;
            second.next=first;
            second = temp2;
        }
        return ;
    }
}
//find middle
// [middle+1,last] -> reverse
//maintain two poointers and join links
//LeetCode 143