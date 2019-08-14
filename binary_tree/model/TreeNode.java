package binary_tree.model;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer x) {
        val = x;
    }

    /**
     * Encodes a tree to a single string
     */
    public static String serialize(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();

        result.add("[" + root.val.toString() + ",");
        serializeHelp(root, 0, result);

        for (int i = result.size() - 1; i >= 0; i--) {
            try {
                String element = result.get(i).substring(0, result.get(i).length() - 1);
                Integer.parseInt(element);
                break;
            } catch (NumberFormatException n) {
                result.remove(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s: result) {
            sb.append(s);
        }
        sb.replace(sb.length() - 1, sb.length(), "]");
        return sb.toString();
    }

    public static void serializeHelp(TreeNode root, int pos, ArrayList<String> result) {
        if (root == null) {
            return;
        }
        if (2*pos + 2 >= result.size()) {
            for (int i = 0; i <= 2*pos + 2; i++) {
                result.add("x");
            }
        }
        result.set(2*pos + 1, root.left == null || root.left.val == null ? "null," : root.left.val.toString() + ",");
        result.set(2*pos + 2, root.right == null || root.right.val == null ? "null," : root.right.val.toString() + ",");

        serializeHelp(root.left, 2*pos+1, result);
        serializeHelp(root.right, 2*pos+2, result);
    }



    /**
     * Decodes the encoded data to tree
     */
    public static TreeNode deserialize(String input) {
        input = input.substring(1, input.length() - 1);
        String[] inputStr = input.split(",");
        List<Integer> inputInt = new ArrayList<>();
        for (String s: inputStr) {
            try {
                inputInt.add(new Integer(s));
            } catch (NumberFormatException n) {
                inputInt.add(null);
            }
        }

        TreeNode result = new TreeNode(inputInt.get(0));
        deserializeHelp(result, 0, inputInt);
        return result;
    }

    public static void deserializeHelp(TreeNode node, int index, List<Integer> input) {
        if (node == null) {
            return;
        }

        if (2*index + 1 > input.size() - 1) {
            node.left = null;
        } else {
            node.left = new TreeNode(input.get(2*index + 1));
        }

        if (2*index + 2 > input.size() - 1) {
            node.right = null;
        } else {
            node.right = new TreeNode(input.get(2*index + 2));
        }

        deserializeHelp(node.left, 2*index + 1, input);
        deserializeHelp(node.right, 2*index + 2, input);
    }
}