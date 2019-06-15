package binary_tree.model;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer x) {
        val = x;
    }

    /**
     * Construct a binary tree from a heap (minimum length: 1)
     */
    public static TreeNode buildBinaryTree(Integer... input) {
        TreeNode result = new TreeNode(input[0]);
        buildBinaryTreeHelp(result, 0, input);
        return result;
    }

    public static void buildBinaryTreeHelp(TreeNode node, int index, Integer...input) {
        if (node == null) {
            return;
        }

        if (2*index + 1 > input.length - 1) {
            node.left = null;
        } else {
            node.left = new TreeNode(input[2*index + 1]);
        }

        if (2*index + 2 > input.length - 1) {
            node.right = null;
        } else {
            node.right = new TreeNode(input[2*index + 2]);
        }

        buildBinaryTreeHelp(node.left, 2*index + 1, input);
        buildBinaryTreeHelp(node.right, 2*index + 2, input);
    }
}