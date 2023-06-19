import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private int maxDepth = 0;
    private int minWidth = Integer.MAX_VALUE;
    private int maxWidth = Integer.MIN_VALUE;

    private Map<Integer, Map<Integer, List<Integer>>> depthValuesByWidth = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = minWidth; i <= maxWidth; i++) {
            if (!depthValuesByWidth.containsKey(i)) {
                continue;
            }

            List<Integer> widthResult = new ArrayList<>();
            Map<Integer, List<Integer>> valuesByDepth = depthValuesByWidth.get(i);

            for (int j = 0; j <= maxDepth; j++) {
                if (valuesByDepth.containsKey(j)) {
                    List<Integer> toAdd = valuesByDepth.get(j);
                    Collections.sort(toAdd);
                    widthResult.addAll(toAdd);
                }
            }

            result.add(widthResult);
        }


        return result;
    }


    private void dfs(TreeNode node, int width, int depth) {
        if (node == null) {
            return;
        }


        minWidth = Math.min(minWidth, width);
        maxWidth = Math.max(maxWidth, width);
        maxDepth = Math.max(maxDepth, depth);

        depthValuesByWidth.computeIfAbsent(width, key -> new HashMap<>())
                .computeIfAbsent(depth, key -> new ArrayList<>())
                .add(node.val);


        dfs(node.left, width - 1, depth + 1);
        dfs(node.right, width + 1, depth + 1);
    }
}