package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalIterator {
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

    public List<Integer> implement_tree_iterator(BinaryTreeNode root, List<String> operations) {
        List<Integer> result = new ArrayList<>();
        InorderIterator iterator = new InorderIterator(root);

        for(String s : operations) {
            if(s.equals("next")) result.add(iterator.next());
            else result.add(iterator.hasNext());
        }

        return result;
    }

    static class InorderIterator {
        Stack<BinaryTreeNode> stack;

        InorderIterator(BinaryTreeNode root) {
            stack = new Stack<>();
            pushToStack(root);
        }

        int next() {
            if(hasNext() == 0) return 0;

            // The reason we pop the latest from stack is to now return the value and add the right subtree
            BinaryTreeNode temp = stack.pop();
            pushToStack(temp.right);

            return temp.value;
        }

        int hasNext() {
            if(!stack.isEmpty()) return 1;

            return 0;
        }

        private void pushToStack(BinaryTreeNode node) {
            // We're using while here as inorder first traverses all the left subtree, so we need to put all the leftmost nodes in the stack so as to remove it one by one later
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
