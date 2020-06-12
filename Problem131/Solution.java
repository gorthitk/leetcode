import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<List<String>> partition(String s)
    {
        List<List<String>> result = new ArrayList<List<String>>();
        getPartitions(s, result, 0, new ArrayList<>());
        return result;
    }

    private void getPartitions(String s, List<List<String>> result, int idx, List<String> arrayList)
    {
        if (idx >= s.length())
        {
            result.add(new ArrayList<>(arrayList));
            return;
        }
        for (int i = idx; i < s.length(); i++)
        {
            if (isPalindrome(s, idx, i))
            {
                arrayList.add(s.substring(idx, i + 1));
                getPartitions(s, result, i + 1, arrayList);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j)
    {
        while (i < j)
        {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}