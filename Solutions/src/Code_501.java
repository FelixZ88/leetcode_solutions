import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Code_501 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Code_501 c = new Code_501();

        TreeNode n = new TreeNode(6);
        n.left = new TreeNode(2);
        n.left.left = new TreeNode(0);
        n.left.right = new TreeNode(4);
        n.left.right.left = new TreeNode(2);
        n.left.right.right = new TreeNode(6);
        n.right = new TreeNode(8);
        n.right.left = new TreeNode(7);
        n.right.right = new TreeNode(9);
        System.out.println(c.findMode(n));
    }

    TreeNode prev = null;
    int curCount = 1;
    int maxModeCount = 1;
    ArrayList<Integer> modes = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        travesal(root);

        int[] res = new int[modes.size()];
        for (int i = 0; i < modes.size(); i ++) {
            res[i] = modes.get(i);
        }
        return res;
    }

    public void travesal(TreeNode node) {
        if (node == null) {
            return ;
        }

        travesal(node.left);


        if (prev != null) {
            if (prev.val == node.val) {
                curCount += 1;
                if (curCount > maxModeCount) {
                    maxModeCount = curCount;
                    modes.clear();
                    modes.add(node.val);
                } else if (curCount == maxModeCount){
                    modes.add(node.val);
                }
            } else {
                curCount = 1;
                if (maxModeCount == 1) {
                    modes.add(node.val);
                }
            }
        } else {
            curCount = 1;
            maxModeCount = 1;
            modes.add(node.val);
        }
        prev = node;

        travesal(node.right);
    }
}
