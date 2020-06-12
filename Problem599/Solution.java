public class Solution
{
    public String[] findRestaurant(String[] list1, String[] list2)
    {
        Map<String, Integer> restaurants1 = new HashMap<>();

        List<String> favs = new ArrayList<>();
        for (int i = 0; i < list1.length; i++)
        {
            restaurants1.put(list1[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++)
        {
            String name = list2[i];
            if (restaurants1.containsKey(name))
            {
                int sum = i + restaurants1.get(name);
                if (sum < minSum)
                {
                    minSum = sum;
                    favs = new ArrayList<>();
                    favs.add(name);
                }
                else if (sum == minSum)
                {
                    favs.add(name);
                }
            }
        }

        return favs.stream().toArray(String[]::new);
    }
}