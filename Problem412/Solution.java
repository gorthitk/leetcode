class Solution {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            boolean isDivisibleBy3 = i % 3 == 0;
            boolean isDivisibleBy5 = i % 5 == 0;
            boolean isDivisibleBy15 = i % 15 == 0;

            if (isDivisibleBy15) {
                result.add(FIZZBUZZ);
                continue;
            }

            if (isDivisibleBy3) {
                result.add(FIZZ);
                continue;
            }

            if (isDivisibleBy5) {
                result.add(BUZZ);
                continue;
            }

            result.add(String.valueOf(i));
        }

        return result;
    }
}