package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderWithoutRecursion {
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

    public List<Integer> postorder_traversal(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            BinaryTreeNode curr = stack.pop();
            stack2.push(curr);

            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);
        }

        while(!stack2.isEmpty()) result.add(stack2.pop().value);

        return result;
    }
}
