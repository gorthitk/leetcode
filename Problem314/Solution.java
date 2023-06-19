import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    class TreeNodeWithLevel {
        int level;
        TreeNode node;

        TreeNodeWithLevel(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // initial data structures.
        Map<Integer, List<Integer>> levels = new HashMap<>();

        // BFS
        Queue<TreeNodeWithLevel> queue = new LinkedList<>();
        queue.add(new TreeNodeWithLevel(0, root));
        int minLevel = Integer.MAX_VALUE, maxLevel = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNodeWithLevel nodeWithLevel = queue.poll();
                int level = nodeWithLevel.level;
                TreeNode curr = nodeWithLevel.node;

                // Update level range.
                minLevel = Math.min(minLevel, level);
                maxLevel = Math.max(maxLevel, level);

                levels.computeIfAbsent(level, k -> new ArrayList<>()).add(curr.val);

                // Visit left node.
                if (curr.left != null) {
                    queue.add(new TreeNodeWithLevel(level -1, curr.left));
                }

                // Visit right node.
                if (curr.right != null) {
                    queue.add(new TreeNodeWithLevel(level +1, curr.right));
                }

                size--;
            }
        }

        // transform into desired output.
        List<List<Integer>> result = new ArrayList<>();

        for (int i = minLevel; i <= maxLevel; i++ ) {
            result.add(levels.get(i));
        }

        return result;
    }
}