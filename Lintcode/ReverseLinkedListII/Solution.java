public class Solution {
        
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (head == null) {
            return null;
        }
        
        
        ListNode before = head;
        ListNode post = head;
        int i = 1;
        while (i < m - 1) {
            before = before.next;
            i++;
        }
        
        int j = 1;
        while (j < m + 1) {
            post = post.next;
            j++;
        }
        
        ListNode dummyHead = before.next;
       
        ListNode prev = null;
        i++;
        
        while (i <= m) {
            ListNode temp = dummyHead.next;
            dummyHead.next = prev;
            prev = dummyHead;
            dummyHead = temp;
            i++;
        }
        
        before.next.next = post;
        before.next = prev;
        return head;

    }
}