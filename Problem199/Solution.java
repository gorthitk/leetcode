public class Solution
{
    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> list = new ArrayList<Integer>();
        populateRightSideView(root, 0, list);
        return list;
    }

    private void populateRightSideView(TreeNode root, int level, List<Integer> list)
    {
        if (root == null)
        {
            return;
        }
        if (level == list.size())
        {
            list.add(root.val);
        }
        populateRightSideView(root.right, level + 1, list);
        populateRightSideView(root.left, level + 1, list);
    }
}