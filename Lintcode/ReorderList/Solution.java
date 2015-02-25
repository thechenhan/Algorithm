public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public static ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;        
    }
    
    public static ListNode reverseLink(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    public static void mergeTwoList(ListNode head, ListNode tail) {
        ListNode dummy = new ListNode(0);
        int flag = 1;
        while (dummy != null) {
            if (flag == 1) {
                flag = 2;
                dummy.next = head;
                if (head != null) {
                    head =head.next;
                }
            } else {
                flag = 1;
                dummy.next = tail;
                if (tail != null) {
                    tail = tail.next;
                }
            }
            dummy = dummy.next;
        }
    }
    
    public void reorderList(ListNode head) {  
        if (head == null) {
            return;
        }
        ListNode mid = findMidNode(head);
        ListNode tail = reverseLink(mid.next);
        mid.next = null;
        mergeTwoList(head, tail);
    }
}