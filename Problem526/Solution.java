
public class Solution
{
    private int count = 0;

    public int countArrangement(int N)
    {
        generateArrangment(new boolean[N + 1], 1, N);
        return count;
    }

    private void generateArrangment(boolean[] visited, int curr, int N)
    {
        if (curr > N)
        {
            count++;
            return;
        }
        for (int i = 1; i <= N; i++)
        {
            if (!visited[i] && posSatisfied(curr, i))
            {
                visited[i] = true;
                generateArrangment(visited, curr + 1, N);
                visited[i] = false;
            }
        }
    }

    private boolean posSatisfied(int i, int num)
    {
        return num % i == 0 || i % num == 0;
    }
}