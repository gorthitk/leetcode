class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int l = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            int sum = 0;
            while(sz-- > 0) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            if (sum > max) {
                max = sum;
                level = l;
            }

            l++;
        }

        return level;
    }
}