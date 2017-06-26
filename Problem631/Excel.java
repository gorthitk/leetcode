import java.util.HashMap;
import java.util.Map;

public class Excel {
	int[][] sheet;

	Map<String, String[]> Sumfunctions;
	public Excel(int H, char W) {
		int n = W - 'A' + 1;
		sheet = new int[H][n];
		Sumfunctions = new HashMap<>();
	}

	public void set(int r, char c, int v) {
		Sumfunctions.remove("" + r + c);
		sheet[r - 1][c - 'A'] = v;
	}

	public int get(int r, char c) {
		return Sumfunctions.get("" + r + c) == null ? sheet[r - 1][c - 'A'] : sum(r, c , Sumfunctions.get("" + r + c));
	}

	public int sum(int r, char c, String[] strs) {
		Sumfunctions.put("" + r + c, strs);
		int sum = 0;
		for (String str : strs) {
			if (str.contains(":")) {
				String[] boundaries = str.split(":");
				String left = boundaries[0];
				String right = boundaries[1];
				int rowStart = 0, rowEnd = 0;
				int start = 1;
				while (start < left.length()) {
					rowStart = rowStart* 10 + (left.charAt(start++)-'0');
				}
				start = 1;
				while(start < right.length()) {
					rowEnd = rowEnd*10 + (right.charAt(start++)-'0');
				}
				for (char i = left.charAt(0); i <= right.charAt(0); i++) {
					for (int j = rowStart; j <= rowEnd; j++) {
						sum += get(j, i);
					}
				}
			} else {
				sum += get(str.charAt(1) - '0', str.charAt(0));
			}
		}
		sheet[r - 1][c - 'A'] = sum;
		return sum;
	}
}
