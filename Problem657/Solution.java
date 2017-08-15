public class Solution {
	public boolean judgeCircle(String moves) {
		int[] pt = new int[2];
		for (int i = 0; i < moves.length(); i++) {
			char move = moves.charAt(i);
			if (move == 'U') {
				pt[1] += 1;
			} else if (move == 'D') {
				pt[1] -= 1;
			} else if (move == 'R') {
				pt[0] += 1;
			} else {
				pt[0] -= 1;
			}
		}
		return pt[0] == 0 && pt[1] == 0;
	}
}