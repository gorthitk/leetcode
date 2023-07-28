import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    TreeNode target = null;
    int minD = Integer.MAX_VALUE;
    TreeNode result = null;
    Map<TreeNode, TreeNode> parents = new HashMap<>();

    public int findClosestLeaf(TreeNode root, int k) {
        findParents(root, null, k);

        if (target.left == null && target.right == null) {
            return target.val;
        }

        dfs(target, 0, new HashSet<>());


        return result.val;
    }

    private void dfs(TreeNode node, int depth, Set<TreeNode> seen) {
        if (node == null) {
            return;
        }

        if (!seen.add(node)) {
            return;
        }

        if (depth > minD) {
            return;
        }

        if (node.left == null && node.right == null) {
            minD = depth;
            result = node;
        }

        dfs(node.left, depth + 1, seen);
        dfs(node.right, depth + 1, seen);
        dfs(parents.get(node), depth + 1, seen);
    }

    private void findParents(TreeNode node, TreeNode parent, int k) {
        if (node == null) {
            return;
        }

        if (node.val == k) {
            target = node;
        }

        if (parent != null) {
            parents.put(node, parent);
        }

        findParents(node.left, node, k);
        findParents(node.right, node, k);
    }
}