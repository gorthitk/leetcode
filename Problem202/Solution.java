class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            if (!seen.add(n)) {
                return false;
            }

            if (n < 10) {
                return n == 7;
            }

            int next = 0;
            while (n > 0) {
                next += (n % 10) * (n % 10);
                n = n / 10;
            }

            n = next;
        }

        return true;
    }
}