/**
 * @author tgorthi
 * @since Jun 2020
 */
public class Solution2
{
    private long count = 0;

    public static void main(String args[])
    {
        Solution2 sol = new Solution2();
        System.out.println(sol.checkRecord(16));
    }

    public int checkRecord(int n)
    {
        dfs("", n, 0, 0);
        return (int) (count % 1000000007);
    }

    private void dfs(String curr, int n, int absentCnt, int len)
    {
        if (len == n)
        {
            count++;
            return;
        }
        String present = curr + 'P';
        dfs(present, n, absentCnt, len + 1);
        if (absentCnt == 0)
        {
            String absent = curr + 'A';
            dfs(absent, n, absentCnt + 1, len + 1);
        }
        String late = curr + 'L';
        if (len >= 2)
        {
            if (curr.charAt(len - 1) != 'L' || curr.charAt(len - 2) != 'L')
            {
                dfs(late, n, absentCnt, len + 1);
            }
        }
        else
        {
            dfs(late, n, absentCnt, len + 1);
        }
    }
}