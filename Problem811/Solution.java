import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution
{
    public List<String> subdomainVisits(String[] cpdomains)
    {
        Map<String, Integer> counts = new HashMap<>();
        for (String cpdomain : cpdomains)
        {
            String[] line = cpdomain.split(" ");
            int count = Integer.valueOf(line[0]);
            String[] domains = line[1].split("\\.");
            String parentDomain = "";
            for (int i = domains.length-1; i >=0 ; i--)
            {
                parentDomain = domains[i] + (parentDomain.equals("") ? parentDomain : "." + parentDomain);
                counts.put(parentDomain, counts.getOrDefault(parentDomain, 0) + count);
            }
        }

        return counts.entrySet().stream().map(e -> e.getValue() + " " + e.getKey()).collect(Collectors.toList());
    }
}