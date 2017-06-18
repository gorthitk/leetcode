public class Solution {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int count = 0, n = A.length;
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				counts.put(A[i] + B[j], counts.getOrDefault(A[i] + B[j], 0) + 1);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				count += counts.getOrDefault((C[i] + D[j]) * -1, 0);
			}
		}

		return count;
	}

}