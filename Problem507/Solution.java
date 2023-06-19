
public class Solution
{
    public boolean checkPerfectNumber(int num)
    {
        int sum = 0;
        int limit = (int) Math.sqrt(num);
        for (int i = 1; i <= limit; i++)
        {
            if (num % i == 0)
            {
                sum += i;
                sum += num / i;
            }
        }
        return num <= 1 ? false : sum == 2 * num;
    }
}