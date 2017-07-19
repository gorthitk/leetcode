import java.util.*;

public class Solution {
	public String frequencySort(String s) {
		Map<Character, Integer> counts = new HashMap<>();
		for (char c : s.toCharArray()) {
			counts.put(c, counts.getOrDefault(c, 0) + 1);
		}
		PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
		queue.addAll(counts.keySet());
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			int k = counts.get(queue.peek());
			while (k > 0) {
				sb.append(queue.poll());
				k--;
			}
		}
		return sb.toString();
	}
}