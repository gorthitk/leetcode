import java.util.Arrays;

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;

        Arrays.sort(properties, (a,b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int count = 0;


        int max = properties[n-1][1];
        for (int i = n - 2; i >= 0; i--) {
            if (properties[i][1] < max) {
                count++;
            }
            max = Math.max(max, properties[i][1]);
        }

        return count;
    }
}