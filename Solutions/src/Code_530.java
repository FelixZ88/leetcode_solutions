import java.util.LinkedList;
import java.util.Queue;

public class Code_530 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList();
        Queue<TreeNode> q2 = new LinkedList();
        q1.offer(root);
        q2.offer(root);

        while (q1.size() > 0) {

            int size1 = q1.size();
            int size2 = q2.size();

            if (size1 != size2) {
                return false;
            }

            for (int i = 0; i < size1; i ++) {
                TreeNode n1 = q1.poll();
                TreeNode n2 = q2.poll();

                if (n1 == null && n2 == null) {
                    return true;
                }

                if (n1 == null || n2 == null) {
                    return false;
                }

                if (n1.val != n2.val) {
                    return false;
                }

                if (n1.left != null && n2.right != null) {
                    q1.offer(n1.left);
                    q2.offer(n2.right);
                } else if (n1.left == null && n2.right == null) {
                } else {
                    return false;
                }

                if (n1.right != null && n2.left != null) {
                    q1.offer(n1.right);
                    q2.offer(n2.left);
                } else if (n1.right == null && n2.left == null) {

                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val == node2.val) {
            return isSame(node1.left, node2.right) && isSame(node1.right, node2.left);
        }
        return false;
    }
}
