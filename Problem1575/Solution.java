import java.util.Arrays;

class Solution {
    private static final long MOD = 1000_000_007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] dp = new int[n][fuel + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dfs(start, finish, fuel, locations, dp);
    }


    private int dfs(
            int curr,
            int finish,
            int fuel,
            int[] locations,
            int[][] dp
    ) {
        int result = 0;

        if (dp[curr][fuel] != -1) {
            return dp[curr][fuel];
        }

        if (curr == finish) {
            result++;
        }

        for (int i = 0; i < locations.length; i++) {
            int required = Math.abs(locations[i] - locations[curr]);
            boolean canVisit = i != curr && required <= fuel;
            if (canVisit) {
                result += dfs(i, finish, fuel - required, locations, dp);
                result %= MOD;
            }
        }

        dp[curr][fuel] = result;

        return result;
    }
}