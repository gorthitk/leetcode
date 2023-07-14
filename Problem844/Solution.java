class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;

        while (i >= 0 && j >= 0) {
            i = getNextIdx(s, i);
            j = getNextIdx(t, j);

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            i--;
            j--;
        }



        return i < 0 && j < 0;
    }


    private int getNextIdx(String s, int i) {
        int skipS = 0;
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                skipS++;
                i--;
            } else if (skipS > 0) {
                skipS--;
                i--;
            } else {
                break;
            }
        }

        return i;
    }
}