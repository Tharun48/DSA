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
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null) {
            list.add(head.val);
            head=head.next;
        }
        return checkPalindrome(list);
    }
}