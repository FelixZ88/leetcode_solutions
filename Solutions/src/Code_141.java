public class Code_141 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;

        while (slow != null && fast != null) {

            if (fast == slow) {
                return true;
            }

            slow = slow.next;

            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
        }

        return false;
    }
}
