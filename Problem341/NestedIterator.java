import java.utils.*;

public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        populate(nestedList);
    }

    @Override
    public Integer next() {
        NestedInteger ni = stack.pop();
        return ni.getInteger();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void populate(List<NestedInteger> list) {
        int n = list.size();

        for (int i = n - 1; i >= 0; i--) {
            NestedInteger ni = list.get(i);
            if (ni.isInteger()) {
                stack.add(ni);
            } else {
                populate(ni.getList());
            }
        }
    }
}
