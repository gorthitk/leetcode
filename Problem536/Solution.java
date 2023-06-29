class Solution {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        char[] arr = s.toCharArray();
        int n = arr.length;

        return str2tree(arr, 0, n);
    }

    private TreeNode str2tree(char[] arr, int start, int end) {
        if (end > arr.length) {
            return null;
        }

        int i = start;
        while (i < end && arr[i] != '(') {
            i++;
        }

        int val = getNumericValue(arr, start, i);
        TreeNode node = new TreeNode(val);

        int lEnd = -1;
        if (i < end) {
            lEnd = findEndIdx(arr, i);
            node.left = str2tree(arr, i + 1, lEnd);
        }

        if (lEnd != -1  && lEnd < end - 1) {
            int rStart = lEnd + 1;
            node.right = str2tree(arr, rStart + 1, findEndIdx(arr, rStart));
        }

        return node;
    }


    private static int getNumericValue(char[] arr, int start, int end) {
        int sign = arr[start] == '-' ? -1 : 1;

        int val = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] == '-' || arr[i] == '+') {
                continue;
            }

            val = val * 10 + (arr[i] -'0');
        }

        return val * sign;
    }

    private int findEndIdx(char[] arr, int start) {
        int open = 1;

        int i = start + 1;
        while (open != 0) {
            if (arr[i] == '(') {
                open++;
            }

            if (arr[i] == ')') {
                open--;
            }

            i++;
        }

        return i - 1;
    }
}