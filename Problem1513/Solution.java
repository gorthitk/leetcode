class Solution {
    private static final int mod = 1000000007;

    public int numSub(String s) {
        int n = s.length();

        long result = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count++;
                result += count;
            } else {
                count = 0;
            }
        }
        return (int) (result % (1e9 + 7));
    }
}