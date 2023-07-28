class Solution {
    public List<String> generatePalindromes(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        List<String> result = new ArrayList<>();
        Character oddChar = null;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                if (oddChar != null) {
                    return result;
                }

                oddChar = (char)('a' + i);
                count[i]--;
            }
        }



        StringBuilder sb = new StringBuilder();
        if (oddChar != null) {
            sb.append(oddChar);
        }

        generate(sb, count, result, s.length());

        return result;
    }


    private void generate(StringBuilder curr, int[] count, List<String> result, int n) {
        if (curr.length() == n) {
            result.add(curr.toString());
            return;
        }


        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                continue;
            }

            char ch = (char)('a' + i);
            count[i] -= 2;
            curr.insert(0, ch);
            curr.append(ch);

            generate(curr, count, result, n);

            count[i] += 2;
            curr.deleteCharAt(0);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
