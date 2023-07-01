class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);

        generate(numRows, result);

        return result;
    }

    private void generate(int numRows, List<List<Integer>> result) {
        if (numRows == 1) {
            result.add(List.of(1));
            return;
        }

        if (numRows == 2) {
            result.add(List.of(1));
            result.add(List.of(1, 1));
            return;
        }

        generate(numRows - 1, result);
        List<Integer> previous = result.get(result.size() - 1);

        List<Integer> res = new ArrayList<>();
        res.add(1);

        for (int i = 1; i < previous.size(); i++) {
            res.add(previous.get(i) + previous.get(i-1));
        }
        res.add(1);

        result.add(res);
    }
}