class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int sbLen = sb.length();
            if (sbLen > 0 && sb.charAt(sbLen - 1) == ch) {
                sb.deleteCharAt(sbLen - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}