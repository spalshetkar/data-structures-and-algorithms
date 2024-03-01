package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathSumEqualsK {
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
    List<List<Integer>> all_paths_sum_k(BinaryTreeNode root, Integer k) {
        List<List<Integer>> result = new ArrayList<>();

        helper(root, k, new ArrayList<>(), result);

        if(result.size() == 0) result.add(Arrays.asList(-1));

        return result;
    }

    private void helper(BinaryTreeNode root, int k, ArrayList<Integer> slate, List<List<Integer>> result) {
        // Base Case
        if(root.left == null && root.right == null) {
            if(k == root.value) {
                slate.add(root.value);
                result.add(new ArrayList<>(slate));
                slate.remove(slate.size() - 1);
            }
            return;
        }

        // Recursive Case
        int target = k - root.value;

        if(root.left != null) {
            slate.add(root.value);
            helper(root.left, target, slate, result);
            slate.remove(slate.size() - 1);
        }

        if(root.right != null) {
            slate.add(root.value);
            helper(root.right, target, slate, result);
            slate.remove(slate.size() - 1);
        }

        return;
    }
}
