
public class Code_437 {

    public static void main(String[] args) {
        Code_437 c = new Code_437();

        int[] nums = {1, Integer.MIN_VALUE, 2, Integer.MIN_VALUE, 3, Integer.MIN_VALUE, 4, Integer.MIN_VALUE, 5};
        Utils.TreeNode head = Utils.buildTree(nums);

        System.out.println(c.pathSum(head, 3));
    }

    public int pathSum(Utils.TreeNode root, int sum) {
        if (root != null) {
            return pathSum(root.left, sum) + pathSum(root.right, sum) + pathSubSum(root, sum);
        }
        return 0;
    }

    public int pathSubSum(Utils.TreeNode root, int remain) {

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
