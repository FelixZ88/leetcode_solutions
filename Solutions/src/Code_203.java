public class Code_203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                if (prev != null) {
                    prev.next = cur.next;
                    cur = cur.next;
                } else {
                    head = cur.next;
                    cur = cur.next;
                }
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
