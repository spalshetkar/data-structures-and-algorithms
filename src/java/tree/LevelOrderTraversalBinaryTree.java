package tree;

/*
Problem:

Example:

Clarifying questions:

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBinaryTree {
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

    public List<List<Integer>> level_order_traversal(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();

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

            result.add(temp);
        }

        return result;
    }
}

/*
Time Complexity:
Space Complexity:
 */