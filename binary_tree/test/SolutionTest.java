package binary_tree.test;

import binary_tree.model.Solution;
import binary_tree.model.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private TreeNode root = TreeNode.buildBinaryTree(1, 2, 3, 4, 5, 6, 7, null, 8);
    private TreeNode root1 = TreeNode.buildBinaryTree(1, 2, 2, 3, 3);
    private TreeNode root2 = TreeNode.buildBinaryTree(2, 97, 97, 47, 80, -7, -7);
    private TreeNode root3 = TreeNode.buildBinaryTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);
    private TreeNode root4 = TreeNode.buildBinaryTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
    private TreeNode root5 = TreeNode.buildBinaryTree(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);
    private TreeNode root6 = TreeNode.buildBinaryTree(-2, null, -3);
    private TreeNode root7 = TreeNode.buildBinaryTree(5, 5, 1);
    private TreeNode root8 = TreeNode.buildBinaryTree(3, 9, 20, 4, 1, 15, 7, null, null, null, null, 16, 17, null, 5, null, null, null, null, null, 0);

    @Test
    public void testTraversal() {
        System.out.println(Solution.inorderTraversal(root8));
        System.out.println(Solution.preorderTraversal(root3));
        System.out.println(Solution.postorderTraversal(root8));
        System.out.println(Solution.levelOrder(root8));
    }

    @Test
    void testMaxDepth() {
        System.out.println(Solution.maxDepth(root));
    }

    @Test
    void testIsSymmetric() {
        System.out.println(Solution.isSymmetric(root));
        System.out.println(Solution.isSymmetric(root1));
        System.out.println(Solution.isSymmetric(root2));
    }

    @Test
    void testHasPathSum() {
        System.out.println(Solution.hasPathSum(root3, 22));
    }

    @Test
    void testPathSum() {
        System.out.println(Solution.pathSum(root4, 22));
        System.out.println(Solution.pathSum(root5, 8));
        System.out.println(Solution.pathSum(root6, -5));
    }

    @Test
    void testIsUniversalTree() {
        System.out.println(Solution.countUnivalSubtrees(root7));
    }

    @Test
    void testBuildTreeFromInorderAndPostorder() {
        TreeNode n = Solution.buildTreeFromInorderAndPostorder(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        System.out.println(Solution.inorderTraversal(n));
        System.out.println(Solution.postorderTraversal(n));

        TreeNode n1 = Solution.buildTreeFromInorderAndPostorder(new int[]{3, 2, 1}, new int[]{3, 2, 1});
        System.out.println(Solution.inorderTraversal(n1));
        System.out.println(Solution.postorderTraversal(n1));
    }

    @Test
    void testBuildTreeFromPreOrderAndInorder() {
        TreeNode n = Solution.buildTreeFromPreOrderAndInorder(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(Solution.preorderTraversal(n));
        System.out.println(Solution.inorderTraversal(n));
    }
}