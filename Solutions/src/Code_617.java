public class Code_617 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return null;
        }

        int val = 0;
        if (t1 != null && t2 != null) {
            val = t1.val + t2.val;
        } else if (t2 != null) {
            val = t2.val;
        } else {
            val = t1.val;
        }

        TreeNode merge = new TreeNode(val);

        merge.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        merge.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return merge;
    }
}
