package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    private static class TreeNode {
        Integer value;
        List<TreeNode> children;

        TreeNode(Integer value) {
            this.value = value;
            this.children = new ArrayList(3);
        }
    }

    List<List<Integer>> level_order(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return result;

        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            int count = queue.size();
            for(int i = 0; i < count; i++) {
                TreeNode node = queue.remove();

                for(TreeNode n : node.children) queue.add(n);

                temp.add(node.value);
            }

            result.add(temp);
        }

        return result;
    }
}
