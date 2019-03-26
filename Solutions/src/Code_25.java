public class Code_25 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Code_25 c = new Code_25();

        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(6);
//        node.next.next.next.next.next.next = new ListNode(7);
//        node.next.next.next.next.next.next.next = new ListNode(8);
//        node.next.next.next.next.next.next.next.next = new ListNode(9);
        c.reverseKGroup(node, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;

        ListNode preTail = null;
        ListNode nextHead = null;
        ListNode left = head;

        while (left != null) {
            ListNode right = left;
            int step = 1;
            while (step < k && right != null) {
                right = right.next;
                step ++;
            }

            if (step != k || right == null) {
                if (newHead == null) {
                    newHead = head;
                }
                break;
            }

            nextHead = right.next;

            ListNode prev = nextHead;
            ListNode cur = left;
            while (cur != nextHead) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            if (preTail != null) {
                preTail.next = right;
                preTail = left;
            } else {
                newHead = right;
                preTail = left;
            }

            left = left.next;
        }


        return newHead;
    }
}
