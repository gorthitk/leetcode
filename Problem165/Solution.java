public class Solution
{
    public int compareVersion(String version1, String version2)
    {
        Queue<String> ver1 = new LinkedList<String>(Arrays.asList(version1.split("\\.")));
        Queue<String> ver2 = new LinkedList<String>(Arrays.asList(version2.split("\\.")));

        while (!ver1.isEmpty() || !ver2.isEmpty())
        {
            int num1 = ver1.isEmpty() ? 0 : ver1.peek().isEmpty() ? 0 : Integer.parseInt(ver1.poll());
            int num2 = ver2.isEmpty() ? 0 : ver2.peek().isEmpty() ? 0 : Integer.parseInt(ver2.poll());
            if (num1 > num2)
                return 1;
            if (num1 < num2)
                return -1;
        }
        return 0;
    }
}