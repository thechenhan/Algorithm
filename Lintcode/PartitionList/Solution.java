public class Solution {
    public static ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode ansLeft = left;
        ListNode ansRight = right;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                head = head.next;
                left = left.next;
            } else {
                right.next = head;
                head = head.next;
                right = right.next;
            }
        }
        
        //since the largest number may not be the last one, we have to manually set it link to null
        right.next = null;
        left.next = ansRight.next;
        return ansLeft.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode ans = partition(head, 3);
    }
}