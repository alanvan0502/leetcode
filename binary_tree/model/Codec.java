package binary_tree.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Codec {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        ArrayList<String> result = new ArrayList<>();

        result.add("[" + root.val + ",");
        serializeHelp(root, 0, result);

        for (int i = result.size() - 1; i >= 0; i--) {
            try {
                String element = result.get(i);
                if (element.charAt(0) == '[') {
                    break;
                }
                if (element.charAt(element.length() - 1) == ',') {
                    element = element.substring(0, result.get(i).length() - 1);
                }
                Integer.parseInt(element);
                break;
            } catch (NumberFormatException n) {
                result.remove(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s);
        }
        sb.replace(sb.length() - 1, sb.length(), "]");
        return sb.toString();
    }

    public void serializeHelp(TreeNode root, int pos, ArrayList<String> result) {
        if (root == null) {
            return;
        }
        if (2 * pos + 2 >= result.size()) {
            for (int i = 0; i <= 2 * pos + 2; i++) {
                result.add("x");
            }
        }
        result.set(2 * pos + 1, root.left == null ? "null," : "" + root.left.val + ",");
        result.set(2 * pos + 2, root.right == null ? "null," : "" + root.right.val + ",");

        serializeHelp(root.left, 2 * pos + 1, result);
        serializeHelp(root.right, 2 * pos + 2, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] inputStr = data.split(",");
        List<Integer> inputInt = new ArrayList<>();
        for (String s : inputStr) {
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

    public void deserializeHelp(TreeNode node, int index, List<Integer> input) {
        if (node == null) {
            return;
        }

        if (2 * index + 1 > input.size() - 1) {
            node.left = null;
        } else {
            if (input.get(2 * index + 1) == null) {
                node.left = null;
            } else {
                node.left = new TreeNode(input.get(2 * index + 1));
            }
        }

        if (2 * index + 2 > input.size() - 1) {
            node.right = null;
        } else {
            if (input.get(2 * index + 2) == null) {
                node.right = null;
            } else {
                node.right = new TreeNode(input.get(2 * index + 2));
            }
        }

        deserializeHelp(node.left, 2 * index + 1, input);
        deserializeHelp(node.right, 2 * index + 2, input);
    }
}
