class Solution {
    public String removeDuplicateLetters(String s) {
        int[] index = new int[26];

        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a'] = i;
        }


        boolean[] seen = new boolean[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (seen[ch - 'a']) {
                continue;
            }

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && index[sb.charAt(sb.length() - 1) - 'a'] > i) {
                char remove = sb.charAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                seen[remove - 'a'] = false;
            }

            sb.append(ch);
            seen[ch - 'a'] = true;
        }


        return sb.toString();
    }
}
