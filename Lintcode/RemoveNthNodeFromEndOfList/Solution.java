public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        dummy.next = head;
        
        while (n > 0) {
            head = head.next;
            n--;
        }
        
        while (head != null) {
            head = head.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    } 
}