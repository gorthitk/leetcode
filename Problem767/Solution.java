class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }


        PriorityQueue<Character> pq = new PriorityQueue<>(
                (ch1,ch2) -> {
                    return count[ch2 - 'a'] - count[ch1 - 'a'];
                }
        );

        int n = s.length();
        for (int i = 0; i < 26; i++) {
            if (count[i] > n / 2 + 1) {
                return "";
            }

            if (count[i] > 0) {
                pq.add((char)('a' + i));
            }
        }

        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            char top1 = pq.poll();
            if (i == 0 || result[i - 1] != top1) {
                result[i] = top1;
                count[top1 - 'a']--;
            } else {
                if (pq.isEmpty()) {
                    return "";
                }

                char top2 = pq.poll();
                result[i] = top2;
                count[top2 - 'a']--;
                if (count[top2 - 'a'] > 0) pq.add(top2);

            }

            if (count[top1 - 'a'] > 0) pq.add(top1);
        }

        return new String(result);
    }
}