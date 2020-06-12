public class Solution
{
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4)
    {
        if (same(p1, p2, p3, p4))
            return false;
        double d1 = squareDistance(p1, p2);
        double d2 = squareDistance(p1, p3);
        double d3 = squareDistance(p1, p4);

        if (d1 == d2 && 2 * d1 == d3)
        {
            double d = squareDistance(p2, p4);
            return (d == squareDistance(p3, p4) && d == d1);
        }

        if (d2 == d3 && 2 * d2 == d1)
        {
            double d = squareDistance(p2, p3);
            return (d == squareDistance(p2, p4) && d == d2);
        }
        if (d1 == d3 && 2 * d1 == d2)
        {
            double d = squareDistance(p2, p3);
            return (d == squareDistance(p3, p4) && d == d1);
        }

        return false;
    }

    private boolean same(int[] p1, int[] p2, int[] p3, int[] p4)
    {

        return compare(p1, p2) || compare(p1, p3) || compare(p1, p4) || compare(p2, p3) || compare(p2, p4)
                || compare(p3, p4);
    }

    private boolean compare(int[] p1, int[] p2)
    {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }

    private double squareDistance(int[] point1, int[] point2)
    {
        return Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2);
    }
}