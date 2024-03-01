package tree;

import sortingAndSearching.MergeKLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeBSTs {
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
    public BinaryTreeNode merge_two_binary_search_trees(BinaryTreeNode root1, BinaryTreeNode root2) {
        // Edge Case
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        // Create inorder lists (sorted arrays) and sort them to create a final inorder list
        List<Integer> result = new ArrayList<>();
        inorder(root1, result);
        inorder(root2, result);
        Collections.sort(result);

        return helper(result, 0, result.size() - 1);
    }

    private void inorder(BinaryTreeNode root, List<Integer> result) {
        if(root == null) return;

        inorder(root.left, result);
        result.add(root.value);
        inorder(root.right, result);

        return;
    }

    private BinaryTreeNode helper(List<Integer> arr, int start, int end) {
        // Base Case
        if(start > end) return null;

        // Recursive Case
        int mid = start + (end - start)/2;

        BinaryTreeNode node = new BinaryTreeNode(arr.get(mid));

        node.left = helper(arr, start, mid - 1);
        node.right = helper(arr, mid + 1, end);

        return node;
    }
}
