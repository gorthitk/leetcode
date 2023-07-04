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
        int previous = 0;
        int result = 0;

        char[] arr = s.toCharArray();
        int n = arr.length;

        int i = 0;
        while (i < n) {
            char ch = arr[i];
            int currentVal = values.get(ch);
            int nextVal = i < n - 1 ? values.get(arr[i+1]) : Integer.MIN_VALUE;

            if (nextVal > currentVal) {
                result += (nextVal - currentVal);
                i+=2;
            } else {
                result += currentVal;
                i++;
            }
        }

        return result;
    }
}