import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code_113 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(5);
        s.left = new TreeNode(4);
        s.left.left = new TreeNode(11);
        s.left.left.left = new TreeNode(7);
        s.left.left.right = new TreeNode(2);
        s.right = new TreeNode(8);
        s.right.left = new TreeNode(13);
        s.right.right = new TreeNode(4);
        s.right.right.left = new TreeNode(5);
        s.right.right.right = new TreeNode(1);

        TreeNode t = new TreeNode(1);
//        t.left = new TreeNode(2);
//        t.right = new TreeNode(1);

        Code_113 c = new Code_113();
        c.pathSum(s, 22);
    }


    List<List<Integer>> sums = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return sums;
        }
        List<Integer> path = new LinkedList<>();
        dfs(root, sum, path);
        return sums;
    }

    public void dfs(TreeNode node, int left, List<Integer> path) {
        if (node.left == null && node.right == null) {
            if (node.val == left) {
                path.add(node.val);
                sums.add(path);
            }
        } else {
            if (node.left != null) {
                List<Integer> list = new LinkedList<>(path);
                list.add(node.val);
                dfs(node.left, left - node.val, list);
            }
            if (node.right != null) {
                List<Integer> list = new LinkedList<>(path);
                list.add(node.val);
                dfs(node.right, left - node.val, list);
            }
        }

    }
}
