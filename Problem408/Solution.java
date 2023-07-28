class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            char ch1 = abbr.charAt(j);
            if (isDigit(ch1)) {
                int num = 0;
                while (j < abbr.length() && isDigit(abbr.charAt(j))) {
                    if (num == 0 && abbr.charAt(j) == '0') {
                        return false;
                    }
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }

                if (i + num > word.length()) {
                    return false;
                }
                i += num;
            } else {
                if (word.charAt(i) != ch1) {
                    return false;
                }
                i++;
                j++;
            }
        }

        return i == word.length() && j == abbr.length();
    }

    private boolean isDigit(char ch1) {
        return ch1 >= '0' && ch1 <= '9';
    }
}