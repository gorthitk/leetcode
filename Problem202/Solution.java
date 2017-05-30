import java.util.HashSet;

public class Solution {
	HashSet<Integer> set = new HashSet<>();
	public boolean isHappy(int n) {
		set.add(n);
		int next = 0;
		while (n >= 10) {
			next += Math.pow(n % 10, 2);
			n /= 10;
		}
		next += Math.pow(n % 10, 2);
		n = next;
		return n == 1 ? true : !set.contains(n) && isHappy(n);
	}
}