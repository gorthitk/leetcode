
public class Solution {
	public String predictPartyVictory(String senate) {
		int radiant = (int) senate.chars().filter(c -> c == 'R').count(), dire = senate.length() - radiant;

		boolean[] banned = new boolean[senate.length()];

		while (radiant != 0 && dire != 0) {
			for (int i = 0; i < senate.length(); i++) {
				if (banned[i]) {
					continue;
				}
				char current = senate.charAt(i);
				banned[getNextIdx(senate, i, banned)] = false;
				if (current == 'R')
					dire--;
				else
					radiant--;
			}
		}

		return radiant == 0 ? "Dire" : "Radiant";
	}

	private int getNextIdx(String senate, int currentIdx, boolean[] banned) {
		char current = senate.charAt(currentIdx);
		int nextId = currentIdx;
		while (nextId < senate.length() && (senate.charAt(nextId) == current || banned[nextId])) {
			nextId++;
		}
		if (nextId == senate.length()) {
			nextId = currentIdx;
			while (senate.charAt(nextId) == current || banned[nextId]) {
				nextId--;
			}
		}
		return nextId;
	}
}