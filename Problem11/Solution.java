
public class Solution {

	// Two pointers solution
	public int maxArea(int[] height) {
		int maxArea = 0;
		if (height == null || height.length == 0)
			return maxArea;
		int i = 0;
		int j = height.length - 1;
		while (i < j) {
			maxArea = Math.max(maxArea, Math.min(height[j], height[i]) * (j - i));
			if (height[i] > height[j])
				j--;
			else
				i++;
		}
		return maxArea;
	}

	// Brute force Solution
	public int maxArea(int[] height) {
		int maxArea = 0;
		if (height == null || height.length == 0)
			return maxArea;

		for (int i = 0; i < height.length; i++) {
			for (int j = 1; j < height.length; j++) {
				maxArea = Math.max(maxArea, Math.min(height[j], height[i]) * (j - i));
			}
		}
		return maxArea;
	}
}