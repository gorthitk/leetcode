import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        Map<Integer, List<TreeNode>> lookup = new HashMap<>();
        lookup.put(0, List.of());
        lookup.put(1, List.of(new TreeNode(0)));

        return generate(n, lookup);
    }

    private static List<TreeNode> generate(int n, Map<Integer, List<TreeNode>> lookup) {
        if (lookup.containsKey(n)) {
            return lookup.get(n);
        }


        List<TreeNode> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<TreeNode> leftNodes = generate(i - 1, lookup);
            List<TreeNode> rightNodes = generate(n - i, lookup);


            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(0, left, right);
                    result.add(root);
                }
            }

        }


        lookup.put(n, result);
        return result;
    }
}
