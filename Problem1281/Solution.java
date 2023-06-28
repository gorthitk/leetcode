class Solution {
    public int subtractProductAndSum(int n) {
        long product = 1;
        long sum = 0;

        while (n > 0) {
            int a = n % 10;
            n = n / 10;

            product *= a;
            sum += a;
        }

        return (int) (product - sum);
    }
}