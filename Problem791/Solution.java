import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();

        for (Character ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (Character ch : order.toCharArray()) {
            int idx = ch - 'a';
            while (count[idx] != 0) {
                sb.append(ch);
                count[idx]--;
            }
        }


        for (Character ch : s.toCharArray()) {
            int idx = ch - 'a';
            while (count[idx] != 0) {
                sb.append(ch);
                count[idx]--;
            }
        }

        return sb.toString();
    }

    public String customSortStringI(String order, String s) {
        int[] ranks = new int[26];

        int rank = 1;
        for (int i = 0; i < order.length(); i++) {
            ranks[order.charAt(i) - 'a'] = rank++;
        }

        List<Character> list = new ArrayList<>();
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            int index = ch - 'a';
            if (ranks[index] == 0) {
                ranks[index] = rank++;
            }

            list.add(ch);
        }


        list.sort(Comparator.comparingInt(ch -> ranks[ch - 'a']));

        StringBuilder sb = new StringBuilder();
        for (Character ch : list) {
            sb.append(ch);
        }

        return sb.toString();
    }
}