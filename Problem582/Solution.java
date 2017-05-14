import java.util.*;

public class Solution {

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		Map<Integer, List<Integer>> mapping = new HashMap<>();
		for (int i = 0; i < pid.size(); i++) {
			int parentProcessId = ppid.get(i);
			mapping.putIfAbsent(parentProcessId, new ArrayList<>());
			mapping.get(parentProcessId).add(pid.get(i));
		}

		List<Integer> killed = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(kill);

		while (!queue.isEmpty()) {
			int processId = queue.poll();
			killed.add(processId);
			if(mapping.containsKey(processId)) {
				queue.addAll(mapping.get(processId));
			}
		}

		return killed;
	}
}