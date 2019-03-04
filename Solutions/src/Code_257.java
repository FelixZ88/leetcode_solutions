import java.util.ArrayList;
import java.util.List;

public class Code_257 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(1);
        s.left.left = new TreeNode(2);
        s.right = new TreeNode(1);
        s.right.left = new TreeNode(2);

        TreeNode t = new TreeNode(1);
//        t.left = new TreeNode(2);
//        t.right = new TreeNode(1);

        Code_257 c = new Code_257();
        c.binaryTreePaths(s);
    }


    List<String> pathes = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        traversal(root, "");
        return pathes;
    }

    public void traversal(TreeNode node, String prefix) {
        if (node != null) {
            String path;
            if (prefix.length() == 0) {
                path = node.val + "";
            } else {
                path = prefix + "->" + node.val;
            }
            if (node.left == null && node.right == null) {
                pathes.add(path);
            } else if (node.left == null) {
                traversal(node.right, path);
            } else if (node.right == null) {
                traversal(node.left, path);
            } else {
                traversal(node.left, path);
                traversal(node.right, path);
            }
        }
    }
}
