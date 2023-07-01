class Solution {
    public int numFriendRequests(int[] ages) {
        int[] counts = new int[121];

        for (int age : ages) {
            counts[age]++;
        }

        int count = 0;
        for (int age : ages) {
            int left = (int) (0.5 * age + 7) + 1;
            for (int i = left; i <= age; i++) {
                count += counts[i];
                if (i == age) {
                    count--;
                }
            }
        }

        return count;
    }
}