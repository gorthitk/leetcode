public class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.min(a.length(), b.length());
    }
}