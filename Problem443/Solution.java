class Solution {
    public int compress(char[] chars) {
        char previous = chars[0];
        int count = 1;

        int k = 0, n = chars.length;
        for (int i = 1; i <= n; i++) {
            if (i == n || chars[i] != previous) {
                k = addCharAndCount(count, previous, chars, k);
                count = 0;
            }

            if (i == n) {
                break;
            }
            previous = chars[i];
            count++;
        }

        return k;
    }

    private int addCharAndCount(int count, char previous, char[] chars, int index) {
        int k = index;
        chars[k++] = previous;
        if (count > 1) {
            char[] cnt = String.valueOf(count).toCharArray();
            for (int j = 0; j < cnt.length; j++) {
                chars[k++] = cnt[j];
            }
        }

        return k;
    }


}