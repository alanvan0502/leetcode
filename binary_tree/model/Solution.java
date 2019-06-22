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

    /**
     * Path sum
     */
    public static boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        int sub_sum = sum - root.val;
        if (sub_sum == 0 && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSum(root.left, sub_sum) || hasPathSum(root.right, sub_sum);
    }

    /**
     * Path sum 3
     */
    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumStartingAtNode(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private static int pathSumStartingAtNode(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.val == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0)
                + pathSumStartingAtNode(root.left, sum - root.val)
                + pathSumStartingAtNode(root.right, sum - root.val);
    }

    public static int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return (isUnivalTree(root) ? 1 : 0)
                + countUnivalSubtrees(root.left)
                + countUnivalSubtrees(root.right);
    }

    public static boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null) {
            return root.val.equals(root.right.val) && isUnivalTree(root.right);
        }
        if (root.right == null) {
            return root.val.equals(root.left.val) && isUnivalTree(root.left);
        }
        return root.val.equals(root.left.val)
                && root.val.equals(root.right.val)
                && isUnivalTree(root.right)
                && isUnivalTree(root.left);
    }

    public static TreeNode buildTreeFromInorderAndPostorder(int[] inorder, int[] postorder) {
        List<Integer> inOrderList = new ArrayList<>();
        for (int i: inorder) {
            inOrderList.add(i);
        }
        List<Integer> postOrderList = new ArrayList<>();
        for (int i: postorder) {
            postOrderList.add(i);
        }
        return buildTreeHelpFromInorderAndPostorder(inOrderList, postOrderList);
    }

    private static TreeNode buildTreeHelpFromInorderAndPostorder(List<Integer> inOrderList, List<Integer> postOrderList) {
        if (postOrderList.size() == 1) {
            return new TreeNode(postOrderList.get(0));
        }
        if (postOrderList.size() == 0) {
            return null;
        }

        int rootVal = postOrderList.get(postOrderList.size() - 1);
        List<Integer> leftInorder = new ArrayList<>();
        List<Integer> rightInorder = new ArrayList<>();

        Stack<Integer> leftPostOrderStack = new Stack<>();
        List<Integer> leftPostOrder = new ArrayList<>();

        Stack<Integer> rightPostOrderStack = new Stack<>();
        List<Integer> rightPostOrder = new ArrayList<>();

        boolean toRight = false;

        for (int value : inOrderList) {
            if (value == rootVal) {
                toRight = true;
                continue;
            }
            if (!toRight) {
                leftInorder.add(value);
            } else {
                rightInorder.add(value);
            }
        }

        for (int i = postOrderList.size() - 2; i >= 0; i--) {
            if (rightPostOrderStack.size() < rightInorder.size()) {
                rightPostOrderStack.push(postOrderList.get(i));
            } else {
                leftPostOrderStack.push(postOrderList.get(i));
            }
        }

        TreeNode result = new TreeNode(rootVal);

        while (!rightPostOrderStack.isEmpty()) {
            rightPostOrder.add(rightPostOrderStack.pop());
        }

        while (!leftPostOrderStack.isEmpty()) {
            leftPostOrder.add(leftPostOrderStack.pop());
        }

        result.left = buildTreeHelpFromInorderAndPostorder(leftInorder, leftPostOrder);
        result.right = buildTreeHelpFromInorderAndPostorder(rightInorder, rightPostOrder);

        return result;
    }

    public static TreeNode buildTreeFromPreOrderAndInorder(int[] preorder, int[] inorder) {
        List<Integer> preOrderList = new ArrayList<>();
        for (int i: preorder) {
            preOrderList.add(i);
        }
        List<Integer> inOrderList = new ArrayList<>();
        for (int i: inorder) {
            inOrderList.add(i);
        }
        return buildTreeFromPreOrderAndInorderHelp(preOrderList, inOrderList);
    }

    private static TreeNode buildTreeFromPreOrderAndInorderHelp(List<Integer> preOrderList, List<Integer> inOrderList) {
        if (preOrderList.size() == 1) {
            return new TreeNode(preOrderList.get(0));
        }
        if (preOrderList.size() == 0) {
            return null;
        }

        int rootVal = preOrderList.get(0);
        List<Integer> leftInorder = new ArrayList<>();
        List<Integer> rightInorder = new ArrayList<>();

        List<Integer> leftPreOrder = new ArrayList<>();
        List<Integer> rightPreOrder = new ArrayList<>();

        boolean toRight = false;

        for (int value : inOrderList) {
            if (value == rootVal) {
                toRight = true;
                continue;
            }
            if (!toRight) {
                leftInorder.add(value);
            } else {
                rightInorder.add(value);
            }
        }

        for (int i = 1; i < preOrderList.size(); i++) {
            if (leftPreOrder.size() < leftInorder.size()) {
                leftPreOrder.add(preOrderList.get(i));
            } else {
                rightPreOrder.add(preOrderList.get(i));
            }
        }

        TreeNode result = new TreeNode(rootVal);

        result.left = buildTreeFromPreOrderAndInorderHelp(leftPreOrder, leftInorder);
        result.right = buildTreeFromPreOrderAndInorderHelp(rightPreOrder, rightInorder);

        return result;
    }

    /**
     * Populating the next right pointers in each node
     */
    public static void connect(Node root) {
        Queue<Node> q = new LinkedList<>();

        if (root != null) {
            q.offer(root);
        }

        Node current;

        while (!q.isEmpty()) {
            List<Node> subResult = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                current = q.poll();
                if (current != null) {
                    subResult.add(current);
                    if (current.left != null) {
                        q.offer(current.left);
                    }
                    if (current.right != null) {
                        q.offer(current.right);
                    }
                }
            }
            for (int i = 0; i < subResult.size(); i++) {
                if (i == subResult.size() - 1) {
                    subResult.get(i).next = null;
                } else {
                    subResult.get(i).next = subResult.get(i+1);
                }
            }
        }
    }
}
