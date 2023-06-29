class Solution {
    private static final Map<Character, Integer> values = Map.of(
            'M', 1000,
            'D', 500,
            'C', 100,
            'L', 50,
            'X', 10,
            'V', 5,
            'I', 1
    );

    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int i = 0, n = s.length();
        int value = 0;
        while (i < n) {
            int curr = values.get(arr[i]);
            int next = i == n - 1 ? 0 : values.get(arr[i + 1]);

            if (curr < next) {
                value += (next - curr);
                i += 2;
            } else {
                value += curr;
                i++;
            }
        }


        return value;
    }
}