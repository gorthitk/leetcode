import java.util.List;

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int result = 0;

        for (NestedInteger ni : nestedList) {
            result += dfs(ni, 1);
        }

        return result;
    }

    private int dfs(NestedInteger ni, int depth) {
        if (ni.isInteger()) {
            return depth * ni.getInteger();
        }


        int result = 0;
        for (NestedInteger ci : ni.getList()) {
            result += dfs(ci, depth + 1);
        }

        return result;
    }
}