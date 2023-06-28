class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[1001];
        for (int num : target) {
            count[num]++;
        }


        for (int num : arr) {
            count[num]--;
        }

        for (int i = 0; i < 1001; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}