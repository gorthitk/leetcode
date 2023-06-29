class Solution {
    private static final Map<Character, char[]> MAPPING = Map.of(
            '2', new char[] {'a', 'b', 'c'},
            '3', new char[] {'d', 'e', 'f'},
            '4', new char[] {'g', 'h', 'i'},
            '5', new char[] {'j', 'k', 'l'},
            '6', new char[] {'m', 'n', 'o'},
            '7', new char[] {'p', 'q', 'r' , 's'},
            '8', new char[] {'t', 'u', 'v'},
            '9', new char[] {'w', 'x', 'y', 'z'}
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        char[] arr = digits.toCharArray();

        backtrack(0, arr, new StringBuilder(), result);

        return result;
    }

    private void backtrack(int curr, char[] arr, StringBuilder sb, List<String> result) {
        if (curr == arr.length) {
            if (sb.length() > 0) {
                result.add(sb.toString());
            }
            return;
        }

        char digit = arr[curr];
        for (char ch : MAPPING.get(digit)) {
            sb.append(ch);
            backtrack(curr + 1, arr, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}