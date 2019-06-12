package binary_tree.test;

import binary_tree.model.Solution;
import binary_tree.model.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void testPreOrderTransversal() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(Solution.preorderTraversal(root));
    }
}