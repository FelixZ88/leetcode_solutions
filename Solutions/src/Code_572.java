public class Code_572 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(1);
//        s.left.left = new TreeNode(2);
//        s.right = new TreeNode(1);
//        s.right.left = new TreeNode(2);

        TreeNode t = new TreeNode(1);
//        t.left = new TreeNode(2);
//        t.right = new TreeNode(1);

        Code_572 c = new Code_572();
        c.isSubtree(s, t);
    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        if (s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode sNode, TreeNode tNode) {
        if (sNode == null && tNode == null) {
            return true;
        } else if (sNode == null || tNode == null) {
            return false;
        } else if (sNode.val == tNode.val) {
            return isSame(sNode.left, tNode.left) && isSame(sNode.right, tNode.right);
        } else {
            return false;
        }
    }

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        String s1 = preorder(s);
        String t1 = preorder(t);
        return s1.contains(t1);
    }

    public String preorder(TreeNode node) {
        StringBuffer sb = new StringBuffer();
        sb.append("#");
        sb.append(node.val);
        if (node.left == null) {
            sb.append("#lnull");
        } else {
            sb.append(preorder(node.left));
        }

        if (node.right == null) {
            sb.append("#rnull");
        } else {
            sb.append(preorder(node.right));
        }
        return sb.toString();
    }
}
