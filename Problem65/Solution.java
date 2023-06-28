class Solution {
    private static final Set<Character> allowed = Set.of('+', '-', 'e', 'E', '.');
    public boolean isNumber(String s) {

        boolean seenDigit = false;
        boolean seenDecimal = false;
        boolean seenE = false;

        int n = s.length();
        char[] arr = s.toCharArray();



        for (int i = 0; i < n; i++) {
            char ch = arr[i];
            if (!allowed.contains(ch) && !isDigit(ch)) {
                return false;
            }
            if (isDigit(ch)) {
                seenDigit = true;
                continue;
            }

            if (ch == '+' || ch == '-') {
                if (i > 0 && arr[i-1] != 'e' && arr[i-1] != 'E') {
                    return false;
                }
            }

            if (ch == '.') {
                if (seenDecimal || seenE) {
                    return false;
                }

                seenDecimal = true;
            }


            if (ch == 'e' || ch == 'E') {
                if (seenE || !seenDigit) {
                    return false;
                }

                seenE = true;
                seenDigit = false;
            }
        }


        return seenDigit;
    }


    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}