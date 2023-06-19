import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strings) {
            String key = calculateKey(str);

            groups.computeIfAbsent(
                    key,
                    k -> new ArrayList<>()
            ).add(str);
        }


        return new ArrayList<>(groups.values());
    }


    private static String calculateKey(String str) {
        char[] arr = str.toCharArray();

        char seed = arr[0];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            int hash = (arr[i] - seed + 26) % 26;
            sb.append(hash);
            sb.append('#');
        }

        return sb.toString();
    }
}