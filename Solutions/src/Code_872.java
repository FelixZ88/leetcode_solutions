import java.util.LinkedList;
import java.util.Queue;

public class Code_872 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> q1 = new LinkedList<>();
        travasal(root1, q1);

        Queue<Integer> q2 = new LinkedList<>();
        travasal(root1, q2);

        if (q1.size() != q2.size()) {
            return false;
        }

        while (q1.size() > 0) {
            Integer i1 = q1.poll();
            Integer i2 = q2.poll();
            if (!i1.equals(i2)) {
                return false;
            }
        }
        return true;
    }

    public void travasal(TreeNode node, Queue<Integer> queue) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                queue.offer(node.val);
            } else {
                travasal(node.left, queue);
                travasal(node.right, queue);
            }
        }
    }
}
