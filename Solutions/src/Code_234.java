
public class Code_234 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Code_234 c = new Code_234();

        //1->2->3->2->1->null
        ListNode head = new ListNode(1);
        ListNode node = head;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;

        System.out.println(c.isPalindrome(head));
    }

    //1->2->3->2->1->null
    //1,2,2,1
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head.next, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode left, right;

        boolean even = true;
        if (fast != null) {
            // 奇数个
            right = slow.next;
        } else {
            right = slow;
        }

        ListNode prev = null, cur = right;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        while (prev != null && head != null) {
            if (prev.val != head.val) {
                return false;
            }

            prev = prev.next;
            head = head.next;

        }
        return true;
    }
}
