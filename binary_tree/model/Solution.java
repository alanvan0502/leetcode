package binary_tree.model;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Pre-order traversal
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        return preorderTraversalHelp(result, root);
    }

    private static List<Integer> preorderTraversalHelp(ArrayList<Integer> result, TreeNode root) {

        if (root == null) {
            return result;
        }

        result.add(root.val);

        preorderTraversalHelp(result, root.left);

        preorderTraversalHelp(result, root.right);

        return result;
    }

    /**
     * In-order traversal
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        return inorderTraversalHelp(result, root);
    }

    private static List<Integer> inorderTraversalHelp(ArrayList<Integer> result, TreeNode root) {

        if (root == null) {
            return result;
        }

        inorderTraversalHelp(result, root.left);

        result.add(root.val);

        inorderTraversalHelp(result, root.right);

        return result;
    }

    /**
     * Post-order traversal
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        return postorderTraversalHelp(result, root);
    }

    private List<Integer> postorderTraversalHelp(ArrayList<Integer> result, TreeNode root) {

        if (root == null) {
            return result;
        }

        postorderTraversalHelp(result, root.left);

        postorderTraversalHelp(result, root.right);

        result.add(root.val);

        return result;
    }
}
