class Solution {

    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length) {
            return false;
        }

        if (arr[start] < 0) {
            return false;
        }

        if (arr[start] == 0) {
            return true;
        }

        int a = start + arr[start];
        int b = start - arr[start];


        arr[start] = -1;


        return canReach(arr, a) || canReach(arr, b);
    }
}