class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int idx = 0;

        int num = 0;
        for (int i = 0; i < abbr.length(); i++) {
            char chr = abbr.charAt(i);
            if (isDigit(chr)) {
                num = num * 10 + (chr - '0');
                // leading zeros.
                if (num == 0) {
                    return false;
                }
            } else {
                idx += num;
                num = 0;
                if (idx >= word.length() || chr != word.charAt(idx++)) {
                    return false;
                }
            }
        }

        if (num != 0) {
            idx += num;
        }

        return idx == word.length();
    }


    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}