import java.util.*;

public class Solution {
	public int scheduleCourse(int[][] courses) {

		Arrays.sort(courses, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		PriorityQueue<Integer> endDay = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		int currentDay = 0;
		for (int i = 0; i < courses.length; i++) {
			currentDay += courses[i][0];
			endDay.add(courses[i][0]);
			if (currentDay > courses[i][1]) currentDay -=endDay.poll();
		}
		return endDay.size();
	}
}