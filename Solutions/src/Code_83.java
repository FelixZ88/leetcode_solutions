public class Code_83 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Code_83 c = new Code_83();

        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);

        System.out.println(c.deleteDuplicates(node));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                break;
            }

            if (cur.val == next.val) {
                cur.next = next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
