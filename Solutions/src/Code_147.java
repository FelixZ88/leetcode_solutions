public class Code_147 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(-1);
        node.next = new ListNode(5);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(0);

        Code_147 c = new Code_147();
        c.insertionSortList(node);
    }

    public ListNode insertionSortList(ListNode head) {

        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            if (prev != null) {
                if (prev.val <= cur.val) {

                } else {
                    ListNode next = cur.next;
                    prev.next = next;
                    ListNode temp = head;
                    ListNode tempPrev = null;
                    while (cur.val > temp.val) {
                        tempPrev = temp;
                        temp = temp.next;
                    }

                    if (tempPrev == null) {
                        cur.next = temp;
                        head = cur;
                    } else {
                        tempPrev.next = cur;
                        cur.next = temp;
                    }
                }
            }

            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}
