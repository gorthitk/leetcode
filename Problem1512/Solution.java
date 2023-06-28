class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] seen = new int[101];


        for (int num : nums) {
            seen[num]++;
        }

        int count = 0;
        for (int i = 0; i <= 100; i++) {
            if (seen[i] > 1) {
                int a = seen[i];
                // Number of sets that can be formed are n * n - 1.
                // Divide by 2 to remove duplicates.
                count += a * (a-1) / 2;
            }

        }

        return count;
    }
}