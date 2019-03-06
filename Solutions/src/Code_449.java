import java.util.LinkedList;
import java.util.Queue;

public class Code_449 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Code_449 c = new Code_449();

        TreeNode n = new TreeNode(2);
        n.left = new TreeNode(1);
        n.right = new TreeNode(3);
        n.right.right = new TreeNode(4);
        System.out.println(c.deserialize(c.serialize(n)));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode EMPTY = new TreeNode(Integer.MIN_VALUE);

        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (queue.size() > 0) {

            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();

                if (node == EMPTY) {
                    sb.append("E");
                    sb.append(",");
                    continue;
                }
                sb.append(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                } else {
                    queue.offer(EMPTY);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                } else {
                    queue.offer(EMPTY);
                }
                sb.append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append("-");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        TreeNode head = null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] rows = data.split("-");
        for (String row : rows) {
            String[] nodes = row.split(",");
            boolean isLeft = true;
            for (String n : nodes) {
                if (head == null) {
                    head = new TreeNode(Integer.valueOf(n));
                    queue.offer(head);
                } else {
                    if (isLeft) {
                        TreeNode node = queue.peek();
                        if (n.equals("E")) {
                            node.left = null;
                        } else {
                            TreeNode newNode = new TreeNode(Integer.valueOf(n));
                            node.left = newNode;
                            queue.offer(newNode);
                        }
                    } else {
                        TreeNode node = queue.poll();
                        if (n.equals("E")) {
                            node.right = null;
                        } else {
                            TreeNode newNode = new TreeNode(Integer.valueOf(n));
                            node.right = newNode;
                            queue.offer(newNode);
                        }
                    }

                    isLeft = !isLeft;
                }
            }
        }

        return head;
    }
}
