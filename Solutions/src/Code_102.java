import java.util.*;

public class Code_102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<List<Integer>> levelValues = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levelValues;
        }
        orderOfLevel(root, 0);
        return levelValues;
    }

    public void orderOfLevel(TreeNode node, int level) {
        if (levelValues.size() > level) {
            List<Integer> levelValue = levelValues.get(level);
            levelValue.add(node.val);
        } else {
            List<Integer> levelValue = new ArrayList<>();
            levelValue.add(node.val);
            levelValues.add(level, levelValue);
        }
        if (node.left != null) {
            orderOfLevel(node.left, level + 1);
        }
        if (node.right != null) {
            orderOfLevel(node.right, level + 1);
        }
    }
}
