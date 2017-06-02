import java.util.*;

public class RandomizedSet {

	List<Integer> list;
	Map<Integer, Integer> indices;

	public RandomizedSet() {
		list = new ArrayList<>();
		indices = new HashMap<>();
	}

	public boolean insert(int val) {
		if (!indices.containsKey(val)) {
			indices.put(val, list.size());
			list.add(val);
			return true;
		}
		return false;
	}

	public boolean remove(int val) {
		if (indices.containsKey(val)) {
			int idx = indices.get(val);
			list.set(idx, list.get(list.size() - 1));
			indices.put(list.get(list.size() - 1), idx);
			indices.remove(val);
			list.remove(list.size() - 1);
			return true;
		}
		return false;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		Random rand = new Random();
		int len = list.size();
		int idx = rand.nextInt(len);
		return list.get(idx);
	}
}
