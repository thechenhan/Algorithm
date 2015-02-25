public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        while (l1 != null && l2 != null) {
           if (l1.val <= l2.val) {
               dummy.next = l1;
               l1 = l1.next;
           } else {
               dummy.next = l2;
               l2 = l2.next;
           }
           
           dummy = dummy.next;
        }
        
        if (l1 == null) {
            dummy.next = l2;
        } else {
            dummy.next = l1;
        }
        
        return ans.next;
    }
}