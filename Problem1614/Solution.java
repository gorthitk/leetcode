class Solution {
    public int maxDepth(String s) {
        return depth(s.toCharArray(), 0, s.length() -1);
    }


    private int depth(char[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int n = arr.length;
        while (i < n) {
            if (arr[i] == '(') {
                break;
            }
            i++;
        }

        while (j >= 0) {
            if (arr[j] == ')') {
                break;
            }
            j--;
        }

        if (i > j) {
            return 0;
        }

        return 1 + depth(arr, i + 1, j -1);
    }
}