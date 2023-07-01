class Solution {
    private Map<Integer, Integer> values = new HashMap<>();
    public int fib(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n != 0 ? 1 : 0;
        }

        if (values.containsKey(n)) {
            return values.get(n);
        }
        int res = fib(n - 1) + fib (n - 2);
        values.put(n, res);

        return res;
    }
}