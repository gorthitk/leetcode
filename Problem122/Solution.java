
public class Solution
{
    public int maxProfit(int[] prices)
    {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++)
        {
            profit = prices[i] < prices[i + 1] ? profit + prices[i + 1] - prices[i] : profit;
        }
        return profit;
    }
}