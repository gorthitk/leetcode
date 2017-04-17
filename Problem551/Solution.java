
public class Solution1 {
	public boolean checkRecord(String s) {
		if (s == null || s.length() == 0)
			return false;
		int absentCnt = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'A') {
				absentCnt++;
				if (absentCnt > 1)
					return false;
			}
			if (c == 'L' && i > 0 && i < s.length() - 1) {
				if (s.charAt(i - 1) == 'L' && s.charAt(i + 1) == 'L') {
					return false;
				}
			}
		}
		return true;
	}
}
