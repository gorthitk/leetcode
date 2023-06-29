class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> xPoints = new HashMap<>();


        for (int[] point : points) {
            int x = point[0], y = point[1];
            xPoints.computeIfAbsent(x, key -> new HashSet<>())
                    .add(y);
        }

        List<Integer> width = new ArrayList<>(xPoints.keySet());

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < width.size(); i++) {
            for (int k = 0; k < i; k++) {
                int prev = width.get(k);
                int curr = width.get(i);

                List<Integer> common = getCommon(prev, curr, xPoints);

                if (common.size() <= 1) {
                    continue;
                }

                for (int j = 1; j < common.size(); j++) {
                    min = Math.min(
                            min,
                            (Math.abs(curr - prev)) * (common.get(j) - common.get(j-1))
                    );
                }
            }
        }


        return min == Integer.MAX_VALUE ? 0 : min;
    }


    private List<Integer> getCommon(int i, int j, Map<Integer, Set<Integer>> xPoints) {
        List<Integer> common = new ArrayList<>();

        Set<Integer> a = xPoints.get(i), b = xPoints.get(j);

        if (a == null || b == null) {
            return common;
        }

        for (int pt : a) {
            if (b.contains(pt)) {
                common.add(pt);
            }
        }

        Collections.sort(common);

        return common;
    }
}