
public class Code_437 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root != null) {
            return pathSum(root.left, sum) + pathSum(root.right, sum) + pathSubSum(root, sum);
        }
        return 0;
    }

    public int pathSubSum(TreeNode root, int remain) {

        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.val == remain) {
            count ++;
        }
        count += pathSubSum(root.left, remain - root.val);
        count += pathSubSum(root.right, remain - root.val);

        return count;
    }
}
