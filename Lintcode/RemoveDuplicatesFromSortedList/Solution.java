public class Solution {

    public static ListNode deleteDuplicates(ListNode head) { 
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next != null) {
          
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
                    
        }
        
        return dummy.next;
    }  

}