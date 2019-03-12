import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code_95 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Code_95 c = new Code_95();
        c.generateTrees(4);
        System.out.println();
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> trees = new LinkedList<>();

        if (n <= 0) {
            return trees;
        }
        TreeNode node = new TreeNode(1);
        trees.add(node);

        if (n == 1) {
            return trees;
        }

        for (int i = 2; i <= n; i ++) {
            List<TreeNode> newTrees = new LinkedList<>();
            for (TreeNode tree : trees) {
                newTrees.addAll(insertNode(tree, i));
            }
            trees = newTrees;
        }

        return trees;
    }

    public List<TreeNode> insertNode(TreeNode root, int val) {
        List<TreeNode> trees = new LinkedList<>();

        TreeNode temp = root;
        while (temp != null) {
            TreeNode newTree = insertNode(root, temp, val);
            trees.add(newTree);
            if (val > temp.val) {
                temp = temp.right;
            } else {
                break;
            }
        }

        TreeNode copy = copyTree(root);
        TreeNode node = new TreeNode(val);
        if (root.val > val) {
            node.right = copy;
        } else {
            node.left = copy;
        }
        trees.add(node);
        return trees;
    }

    public TreeNode insertNode(TreeNode root, TreeNode node, int val) {
        TreeNode copy = copyTree(root);
        TreeNode temp = copy;
        while (temp != null) {
            if (temp.val == node.val) {
                break;
            } else if (temp.val > node.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        TreeNode iNode = new TreeNode(val);
        if (temp.val > val) {
            if (temp.left != null) {
                if (temp.left.val < val) {
                    iNode.left = temp.left;
                } else {
                    iNode.right = temp.left;
                }
            }
            temp.left = iNode;
        } else {
            if (temp.right != null) {
                if (temp.right.val < val) {
                    iNode.left = temp.right;
                } else {
                    iNode.right = temp.right;
                }
            }
            temp.right = iNode;
        }
        return copy;
    }

    public TreeNode copyTree(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        TreeNode node = new TreeNode(tree.val);
        node.left = copyTree(tree.left);
        node.right = copyTree(tree.right);
        return node;
    }
}
