import java.util.*;
import java.util.stream.Collectors;

public class Solution
{
    public List<List<String>> findDuplicate(String[] paths)
    {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths)
        {
            findDuplicates(path, map);
        }
        return map.values().stream().filter(a -> a.size() > 1).collect(Collectors.toList());
    }

    private void findDuplicates(String path, Map<String, List<String>> map)
    {
        String[] tokens = path.split(" ");
        String dirPath = tokens[0];
        for (int i = 1; i < tokens.length; i++)
        {
            String file = tokens[i].substring(0, tokens[i].indexOf("("));
            String content = tokens[i].substring(tokens[i].indexOf("(") + 1, tokens[i].indexOf(")"));
            map.putIfAbsent(content, new ArrayList<>());
            String filePath = dirPath + "/" + file;
            map.get(content).add(filePath);
        }
    }
}