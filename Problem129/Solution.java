public class Solution
{
    private int sum = 0;

    public int sumNumbers(TreeNode root)
    {
        getSum(root, 0);
        return sum;
    }

    private void getSum(TreeNode root, int prevSum)
    {
        if (root == null)
            return;
        int currentSum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null)
        {
            sum += currentSum;
            return;
        }
        getSum(root.left, currentSum);
        getSum(root.right, currentSum);
    }
}