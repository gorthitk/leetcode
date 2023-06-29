class Solution {

    public int maximumSwap(int num) {
        if (num < 10) {
            return num;
        }

        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;

        int[] index = new int[10];
        for (int i = 0; i < n; i++) {
            index[arr[i] - '0'] = i;
        }

        for (int i = 0; i < n; i++) {
            int val = arr[i] - '0';
            for (int j = 9; j > val; j--) {
                if (index[j] > i) {
                    swap(arr, i, index[j]);
                    return Integer.parseInt(new String(arr));
                }
            }
        }

        return num;
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}