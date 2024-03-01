package tree;

import java.util.*;

public class ConstructBSTFromPreorderTraversal {
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

    public BinaryTreeNode build_binary_search_tree(ArrayList<Integer> preorder) {
        if(preorder == null) return null;

        List<Integer> inorder = new ArrayList<>(preorder);
        Collections.sort(inorder);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.size(); i++) map.put(inorder.get(i), i);

        BinaryTreeNode root = helper(preorder, inorder, 0, preorder.size() - 1, 0, inorder.size() - 1, map);

        return root;
    }

    private BinaryTreeNode helper(List<Integer> preorder, List<Integer> inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        // Base Case
        if(inStart > inEnd) return null;

        // Recursive Case
        int root = preorder.get(preStart);
        int preRootIndex = preStart;
        int inRootIndex = map.get(root);

        int count = inRootIndex - inStart;

        BinaryTreeNode node = new BinaryTreeNode(root);

        node.left = helper(preorder, inorder, preStart + 1, preStart + count, inStart, inRootIndex - 1, map);
        node.right = helper(preorder, inorder, preStart + count + 1, preEnd, inRootIndex + 1, inEnd, map);

        return node;
    }
}
