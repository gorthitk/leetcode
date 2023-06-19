

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class Solution
{
    private static final Map<Integer, Integer> ROTATION_PAIRS = new HashMap<Integer, Integer>()
    {{
        put(0, 0);
        put(1, 1);
        put(8, 8);
        put(2, 5);
        put(5, 2);
        put(6, 9);
        put(9, 6);
    }};

    public int rotatedDigits(int N)
    {
        return (int) IntStream.range(1, N + 1).filter(this::_isGoodNumbers).count();
    }

    private boolean _isGoodNumbers(int i)
    {
        List<Integer> digits = new ArrayList<>();
        int num = i;
        while (num != 0)
        {
            int digit = num % 10;
            if (ROTATION_PAIRS.get(digit) == null)
            {
                return false;
            }
            digits.add(ROTATION_PAIRS.get(digit));
            num /= 10;
        }
        final int size = digits.size();
        int rotatedNumber = 0;
        for (int j = size - 1; j >= 0; j--)
        {
            rotatedNumber = rotatedNumber * 10 + digits.get(j);
        }
        return rotatedNumber != i;
    }
}