import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();

        inOrder(root1, nums1);
        inOrder(root2, nums2);


        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1.size() || j < nums2.size()) {
            int a = i < nums1.size() ? nums1.get(i) : Integer.MAX_VALUE;
            int b = j < nums2.size() ? nums2.get(j) : Integer.MAX_VALUE;

            if (a < b) {
                result.add(a);
                i++;
            } else {
                result.add(b);
                j++;
            }
        }


        return result;
    }


    private void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }

        inOrder(node.left, nums);
        nums.add(node.val);
        inOrder(node.right, nums);
    }
}