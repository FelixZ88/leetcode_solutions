public class Code_2 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode header = null, tail = null;
         int carry = 0;
         while (l1 != null || l2 != null) {

            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = val / 10;
            ListNode node = new ListNode(val % 10);

            if (header == null) {
                header = node;
                tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
         }

         if (carry == 1) {
             ListNode node = new ListNode(1);
             tail.next = node;
         }
         return header;
    }
}
