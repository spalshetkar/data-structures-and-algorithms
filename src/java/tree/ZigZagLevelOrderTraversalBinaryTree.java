package tree;

import java.util.*;

public class ZigZagLevelOrderTraversalBinaryTree {
    private class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public List<List<Integer>> zig_zag_level_order_traversal(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        boolean flip = false;

        if(root == null) return result;

        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            int count = queue.size();
            for(int i = 0; i < count; i++) {
                BinaryTreeNode node = queue.remove();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);

                temp.add(node.value);
            }

            if(flip) Collections.reverse(temp);
            flip = !flip;

            result.add(temp);
        }

        return result;
    }
}
