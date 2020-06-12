public class Solution
{
    public boolean canMeasureWater(int x, int y, int z)
    {
        return x + y < z ? false : x == z || y == z || x + y == z || z % getGCD(x, y) == 0;
    }

    private int getGCD(int x, int y)
    {
        int a = x < y ? y : x;
        int b = x < y ? x : y;
        return b == 0 ? a : a % b == 0 ? b : getGCD(b, a % b);
    }
}