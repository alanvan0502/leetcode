package binary_tree.test;

import binary_tree.model.Codec;
import binary_tree.model.Node;
import binary_tree.model.Solution;
import binary_tree.model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {

    private TreeNode root0 = TreeNode.deserialize("[5,2,3,null,null,2,4,3,1]");
    private TreeNode root = TreeNode.deserialize("[1,2,3,4,5,6,7,null,8]");
    private TreeNode root1 = TreeNode.deserialize("[1,2,2,3,3]");
    private TreeNode root2 = TreeNode.deserialize("[2,97,97,47,80,-7,-7]");
    private TreeNode root3 = TreeNode.deserialize("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
    private TreeNode root4 = TreeNode.deserialize("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
    private TreeNode root5 = TreeNode.deserialize("[10,5,-3,3,2,null,11,3,-2,null,1]");
    private TreeNode root6 = TreeNode.deserialize("[-2,null,-3]");
    private TreeNode root7 = TreeNode.deserialize("[5,5,1]");
    private TreeNode root8 = TreeNode.deserialize("[3,9,20,4,1,15,7,null,null,null,null,16,17,null,5,null,null,null,null,null,0]");

    @Test
    public void testTraversal() {
        System.out.println(Solution.inorderTraversal(root0));
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

    @Test
    void testConnect() {
        Node n4 = new Node(4, null, null, null);
        Node n5 = new Node(5, null, null, null);
        Node n6 = new Node(6, null, null, null);
        Node n7 = new Node(7, null, null, null);
        Node n2 = new Node(2, n4, n5, null);
        Node n3 = new Node(3, n6, n7, null);
        Node n1 = new Node(1, n2, n3, null);
        Solution.connect(n1);
        System.out.println(n1);
    }

    @Test
    void testIsAncestor() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t0 = new TreeNode(0);
        t0.left = t1;
        TreeNode root = new TreeNode(-1);
        root.right = t0;
        TreeNode t2 = new TreeNode(1);
        System.out.println(Solution.isAncestor(root, t1));
        System.out.println(Solution.isAncestor(root, t2));
        System.out.println(Solution.isAncestor(root, root));

        List<TreeNode> ancestors2 = new ArrayList<>();
        Solution.findAncestors(root, t2, ancestors2);
        System.out.println(ancestors2);

        List<TreeNode> ancestors1 = new ArrayList<>();
        Solution.findAncestors(root, t1, ancestors1);
        System.out.println(ancestors1);
    }

    @Test
    void testSerialize() {
        String r = TreeNode.serialize(root);
        String r1 = TreeNode.serialize(root1);
        String r2 = TreeNode.serialize(root2);
        String r3 = TreeNode.serialize(root3);
        System.out.println(r);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        System.out.println(TreeNode.serialize(TreeNode.deserialize("[1,2,3,null,null,4,5]")));
    }

    @Test
    void testCodec() {
        Codec codec = new Codec();
        //System.out.println(codec.serialize(codec.deserialize("[1,2,3,null,null,4,5]")));

        Codec.TreeNode n = codec.deserialize("[5,2,3,null,null,2,4,3,1]");
        //System.out.println(codec.serialize(codec.deserialize("[10,5,-3,3,2,null,11,3,-2,null,1]")));
    }
}