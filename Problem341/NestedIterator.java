import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
	Stack<NestedInteger> stack;

	public NestedIterator(List<NestedInteger> nestedList) {
		stack = new Stack<>();
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			if (stack.peek().isInteger()) {
				return true;
			}
			NestedInteger current = stack.pop();
			List<NestedInteger> list = current.getList();
			for (int i = list.size() - 1; i >= 0; i--) {
				stack.push(list.get(i));
			}
		}
		return false;
	}
}
