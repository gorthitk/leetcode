class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                result.add(num);
            }
        }

        return result;
    }
}