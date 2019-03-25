public class Code_23 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Code_23 c = new Code_23();

        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);

        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);

        ListNode[] nodes = {n1, n2, n3};
        c.mergeKLists(nodes);

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode cur = null;

        while (true) {
            int idx = 0;
            ListNode tmp = null;
            for (int i = 0; i < lists.length; i ++) {
                ListNode n = lists[i];
                if (n != null) {
                    if (tmp == null) {
                        tmp = n;
                        idx = i;
                    } else {
                        if (tmp.val > n.val) {
                            tmp = n;
                            idx = i;
                        }
                    }
                }
            }

            if (tmp == null) {
                break;
            }

            if (head == null) {
                head = tmp;
                cur = head;
            } else {
                cur.next = tmp;
                cur = cur.next;
            }


            lists[idx] = lists[idx].next;
        }

        return head;
    }
}
