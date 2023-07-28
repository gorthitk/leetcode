import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    int min = Integer.MAX_VALUE;
    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        recurse(s.toCharArray(), 0, 0, 0, 0, new StringBuilder());
        return new ArrayList<>(result);
    }

    private void recurse(char[] arr, int index, int left, int right, int cnt, StringBuilder sb) {
        // Invalid.
        if (right > left) {
            return;
        }

        // Count is larger than min.
        if (cnt > min) {
            return;
        }

        if (index == arr.length) {
            if (left == right) {
                if (cnt < min) {
                    min = cnt;
                    result = new HashSet<>();
                }

                result.add(sb.toString());
            }

            return;
        }

        char ch = arr[index];

        if (ch != '(' && ch != ')') {
            sb.append(ch);
            recurse(arr, index + 1, left, right, cnt, sb);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }


        // delete the bracket
        recurse(arr, index + 1, left, right, cnt + 1, sb);

        sb.append(ch);
        recurse(arr, index + 1, left + (ch == '(' ? 1 : 0), right + (ch == ')' ? 1 : 0), cnt, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}