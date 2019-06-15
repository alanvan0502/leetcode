package binary_tree.test;

import binary_tree.model.Solution;
import binary_tree.model.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    TreeNode root;
    TreeNode root1;
    TreeNode root2;

    @BeforeEach
    void setUp() {
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.left = new TreeNode(2);
        root1.right.right = new TreeNode(3);
        root1.left.right = new TreeNode(3);

        root2 = new TreeNode(2);
        root2.left = new TreeNode(97);
        root2.right = new TreeNode(97);
        root2.left.right = new TreeNode(47);
        root2.right.left = new TreeNode(80);
        root2.left.right.left = new TreeNode(-7);
        root2.right.left.right = new TreeNode(-7);
    }

    @Test
    public void testTraversal() {
        System.out.println(Solution.preorderTraversal(root));
        System.out.println(Solution.inorderTraversal(root));
        System.out.println(Solution.postorderTraversal(root));
        System.out.println(Solution.levelOrder(root));
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
}