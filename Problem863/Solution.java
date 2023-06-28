import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents  = new HashMap<>();
        findParents(root, null, parents);


        List<Integer> result = new ArrayList<>();
        dfs(target, parents, k, result, new HashSet<>());

        return result;
    }

    private static void dfs(TreeNode node, Map<TreeNode, TreeNode> parents, int distance, List<Integer> result, Set<TreeNode> seen) {
        if (seen.contains(node)) {
            return;
        }

        if (node == null) {
            return;
        }


        seen.add(node);
        if (distance == 0) {
            result.add(node.val);
            return;
        }

        dfs(parents.get(node), parents, distance - 1, result, seen);
        dfs(node.left, parents, distance - 1, result, seen);
        dfs(node.right, parents, distance - 1, result, seen);
    }

    private static void findParents(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parents) {
        if (node == null) {
            return;
        }

        if (parent != null) {
            parents.put(node, parent);
        }


        findParents(node.left, node, parents);
        findParents(node.right, node, parents);
    }
}