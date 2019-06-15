package binary_tree.model;

import java.util.*;

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
    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        return postorderTraversalHelp(result, root);
    }

    private static List<Integer> postorderTraversalHelp(ArrayList<Integer> result, TreeNode root) {

        if (root == null) {
            return result;
        }

        postorderTraversalHelp(result, root.left);

        postorderTraversalHelp(result, root.right);

        result.add(root.val);

        return result;
    }

    /**
     * Level-order traversal (breadth first search)
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.offer(root);
        }

        TreeNode current;

        while (!q.isEmpty()) {
            List<Integer> subResult = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                current = q.poll();
                if (current != null) {
                    subResult.add(current.val);
                    if (current.left != null) {
                        q.offer(current.left);
                    }
                    if (current.right != null) {
                        q.offer(current.right);
                    }
                }
            }
            result.add(subResult);
        }
        return result;
    }

    /**
     * Maximum depth
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rightDepth = 0;
        if (root.right != null) {
            rightDepth = maxDepth(root.right);
        }

        int leftDepth = 0;
        if (root.left != null) {
            leftDepth = maxDepth(root.left);
        }

        return Math.max(rightDepth, leftDepth) + 1;
    }

    /**
     * Symmetric Tree
     */
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode lRoot, TreeNode rRoot) {
        if (lRoot == null && rRoot == null) {
            return true;
        }

        if (lRoot == null || rRoot == null) {
            return false;
        }

        return lRoot.val == rRoot.val && isMirror(lRoot.left, rRoot.right) && isMirror(lRoot.right, rRoot.left);
    }
//
//    /**
//     * Path sum
//     */
//    public static boolean hasPathSum(TreeNode root, int sum) {
//
//    }
}
