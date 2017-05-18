import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		List<String> seed = new ArrayList<>();
		seed.add("");
		allCombinations(s, result, seed, s.length() - 1, 4);
		return result;
	}

	private void allCombinations(String s, List<String> result, List<String> current, int start, int byteIdx) {
		if (start + 1 > byteIdx * 3 || start + 1 < byteIdx * 1) {
			return;
		}
		if (byteIdx == 1) {
			String add = s.substring(0, start + 1);
			if ((add.length() != 1 && add.charAt(0) == '0') || (add.length() == 3 && Integer.parseInt(add) > 255)) {
				return;
			}
			for (String curr : current) {
				result.add(add + "." + curr);
			}
			return;
		}

		for (Integer len : new int[] { 0, 1, 2 }) {
			List<String> newCurrent = new ArrayList<>();
			if (start - len <= start + 1 && start - len > 0) {
				String currByte = s.substring(start - len, start + 1);
				for (String curr : current) {
					String add = currByte;

					if ((add.length() != 1 && add.charAt(0) == '0')
							|| (add.length() == 3 && Integer.parseInt(add) > 255)) {
						continue;
					}
					if (!curr.equals("")) {
						add = add + "." + curr;
					}
					newCurrent.add(add);
				}
				allCombinations(s, result, newCurrent, start - len - 1, byteIdx - 1);
			}
		}
	}
}