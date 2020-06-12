/**
 * @author tgorthi
 * @since Jun 2020
 */
class Solution
{
    private int count = 0;

    public int pseudoPalindromicPaths(TreeNode root)
    {
        count = 0;
        final int[] counter = new int[11];
        _find(root, counter);
        return count;
    }

    private void _find(TreeNode root, int[] counter)
    {
        if (root == null)
        {
            return;
        }
        counter[root.val]++;
        if (root.left == null && root.right == null)
        {
            if (_isPalindrome(counter))
            {
                count++;
            }
        }
        else
        {
            _find(root.left, counter);
            _find(root.right, counter);
        }
        counter[root.val]--;
    }

    private boolean _isPalindrome(int[] counter)
    {
        boolean foundOdd = false;
        for (int i = 1; i <= 10; i++)
        {
            if (counter[i] % 2 != 0)
            {
                if (foundOdd)
                {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }
}