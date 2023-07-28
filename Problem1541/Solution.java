class Solution {
    public int minInsertions(String s) {
        int open = 0, result = 0;
        int i = 0, n = s.length();
        while (i < n) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
                i++;
            } else {
                if (i == n - 1 || s.charAt(i + 1) != ')') {
                    result++;
                    i++;
                } else {
                    i += 2;
                }

                if (open > 0) {
                    open--;
                } else {
                    result++;
                }
            }
        }


        return result + 2 * open;
    }
}