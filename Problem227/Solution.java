import java.util.Set;
import java.util.Stack;

class Solution {
    private static final Set<Character> OPERATORS = Set.of('+', '-', '*', '/');
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.trim();
        Stack<Integer> numbers = new Stack<>();
        char operator = '+';


        int currentNumber = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch == ' ') {
                continue;
            }

            if (isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            }

            if (!isDigit(ch) || i == arr.length - 1) {
                switch (operator) {
                    case '+':
                        numbers.add(currentNumber);
                        break;
                    case '-':
                        numbers.add(-1 * currentNumber);
                        break;
                    case '*':
                        numbers.add(currentNumber * numbers.pop());
                        break;
                    case '/':
                        numbers.add(numbers.pop() / currentNumber);
                        break;
                }
                currentNumber = 0;

                if (OPERATORS.contains(ch)) {
                    operator = ch;
                }
            }
        }


        int result = 0;
        while (!numbers.isEmpty()) {
            result += numbers.pop();
        }
        return result;

    }


    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}