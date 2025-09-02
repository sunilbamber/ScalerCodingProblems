package module5.dsa2.trees.day39;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class BSTSum {

    // Step 1: Find total sum
    public int totalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + totalSum(root.left) + totalSum(root.right);
    }

    // Step 2: Check while traversing if subtree sum equals halfSum
    public boolean checkHalfSum(TreeNode root, int total) {
        if (root == null) return false;
        int half = total / 2;
        return dfs(root, half) != -1;  // if found half sum subtree
    }

    private int dfs(TreeNode node, int half) {
        if (node == null) return 0;
        int left = dfs(node.left, half);
        if (left == -1) return -1;
        int right = dfs(node.right, half);
        if (right == -1) return -1;

        int sum = left + right + node.val;

        if (sum == half) return -1; // marker to indicate found
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        BSTSum obj = new BSTSum();
        int total = obj.totalSum(root);
        System.out.println("Total Sum = " + total);
        System.out.println("Half Sum Exists = " + obj.checkHalfSum(root, total));
    }
}
