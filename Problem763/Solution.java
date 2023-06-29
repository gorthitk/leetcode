class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] index = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            index[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int begin = 0, end = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            end = Math.max(end, index[ch - 'a']);
            if (i == end) {
                result.add(i - begin + 1);
                begin = i + 1;
            }
        }

        return result;
    }
}