import java.util.stream.IntStream;

class Solution {
	public char nextGreatestLetter(char[] letters, char target) {

		return (char) IntStream.range(0, letters.length).map(idx -> letters[idx]).filter(c -> c > target).findAny().orElse(letters[0]);
	}
}