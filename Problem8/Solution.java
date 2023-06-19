class Solution {
    public int myAtoi(String s) {
        char[] arr = s.toCharArray();
        int start = 0;

        while (start < arr.length && arr[start] == ' ') {
            start++;
        }

        int res = 0;
        boolean isNeg = false;
        int cutOff = Integer.MAX_VALUE / 10;

        for (int i = start; i < arr.length; i++) {
            char ch = arr[i];

            if ((ch == '+' || ch == '-') && i == start) {
                isNeg = ch == '-';
                continue;
            }


            if (!isDigit(ch)) {
                break;
            }


            int d = ch - '0';
            if (res > cutOff) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (res == cutOff) {
                if (isNeg && d >= 8) {
                    return Integer.MIN_VALUE;
                }

                if (!isNeg && d >= 7) {
                    return Integer.MAX_VALUE;
                }
            }
            res = res * 10 + d;
        }

        return isNeg ? -1 * res : res;
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}