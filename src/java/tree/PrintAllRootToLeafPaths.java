package tree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllRootToLeafPaths {
    private static class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    List<List<Integer>> all_paths_of_a_binary_tree(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        helper(root, new ArrayList<>(), result);

        return result;
    }

    private void helper(BinaryTreeNode root, List<Integer> slate, List<List<Integer>> result) {
        // Base Case
        if(root.left == null && root.right == null) {
            slate.add(root.value);
            result.add(new ArrayList<>(slate));
            slate.remove(slate.size() - 1);
            return;
        }

        // Recursive Case
        slate.add(root.value);

        if(root.left != null) helper(root.left, slate, result);
        if(root.right != null) helper(root.right, slate, result);

        slate.remove(slate.size() - 1);

        return;
    }
}
