import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
	public List<Integer> selfDividingNumbers(int left, int right) {
		ArrayList<Integer> result = new ArrayList<>();
		IntStream.range(left, right+1).filter(this::isSelfDivingNumber).forEach(result::add);
		return result;
	}

	private boolean isSelfDivingNumber(final Integer num)
	{
		int current = num;
		while (current != 0)
		{
			int digit = current%10;
			if (digit == 0 || num % digit != 0)
			{
				return false;
			}
			current = current/10;
		}
		return true;
	}
}