import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (String str : strs) {
            sb.append(str.length());
            sb.append(',');
        }
        sb.append("]");
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {

        int idx =  s.indexOf(']');
        String[] endIndicies = s.substring(1, idx).split(",");



        List<String> result = new ArrayList<>();
        int curr = idx + 1;
        for (String index : endIndicies) {
             int end = curr + Integer.parseInt(index);
             result.add(s.substring(curr, end));
             curr = end;
        }


        return result;
    }
}