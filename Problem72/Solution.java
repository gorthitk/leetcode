class Solution {
    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        Integer[][] memo = new Integer[arr1.length + 1][arr2.length + 1];

        return findMin(arr1, arr2, arr1.length, arr2.length, memo);
    }

    private int findMin(char[] arr1, char[] arr2, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (i == 0 || j == 0) {
            memo[i][j] = i == 0 ? j : i;
            return memo[i][j];
        }


        if (arr1[i - 1] == arr2[j - 1]) {
            memo[i][j] = findMin(arr1, arr2, i - 1, j - 1, memo);
        } else {
            int insert = findMin(arr1, arr2, i, j - 1, memo);
            int delete = findMin(arr1, arr2, i - 1, j, memo);
            int replace = findMin(arr1, arr2, i - 1, j - 1, memo);


            memo[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }


        return memo[i][j];
    }
}