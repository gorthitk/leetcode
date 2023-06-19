

import java.util.*;

public class LogSystem
{
    Map<String, List<Integer>> logs;
    Map<String, Integer> indices;

    {
        indices = new HashMap<>();
        indices.put("Year", 4);
        indices.put("Month", 7);
        indices.put("Day", 10);
        indices.put("Hour", 13);
        indices.put("Minute", 16);
        indices.put("Second", 19);
    }

    public LogSystem()
    {
        logs = new HashMap<>();
    }

    public void put(int id, String timestamp)
    {
        logs.putIfAbsent(timestamp, new ArrayList<>());
        logs.get(timestamp).add(id);
    }

    public List<Integer> retrieve(String s, String e, String gra)
    {
        int idx = indices.get(gra);
        List<Integer> result = new ArrayList<Integer>();
        for (String time : logs.keySet())
        {
            if (time.substring(0, idx).compareTo(s.substring(0, idx)) >= 0 && time.substring(0, idx).compareTo(e.substring(0, idx)) <= 0)
            {
                result.addAll(logs.get(time));
            }
        }
        return result;
    }
}