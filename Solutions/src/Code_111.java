import java.util.LinkedList;
import java.util.PriorityQueue;

public class Code_111 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class LevelTree {
        TreeNode node;
        int level;
        LevelTree(int l, TreeNode node) {
            level = l;
            this.node = node;
        }
    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<LevelTree> list = new LinkedList<>();

        list.add(new LevelTree(1, root));

        while (list.size() > 0) {
            LevelTree levelnode = list.removeFirst();
            if (levelnode.node.left == null && levelnode.node.right == null) {
                return levelnode.level;
            }

            if (levelnode.node.left != null) {
                list.add(new LevelTree(levelnode.level + 1, levelnode.node.left));
            }
            if (levelnode.node.right != null) {
                list.add(new LevelTree(levelnode.level + 1, levelnode.node.right));
            }
        }

        return list.removeFirst().level;
    }
}
