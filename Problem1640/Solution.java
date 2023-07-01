class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] index = new int[101];
        Arrays.fill(index, -1);

        for (int i = 0; i < arr.length; i++) {
            index[arr[i]] = i;
        }

        int len = 0;
        for (int i = 0; i < pieces.length; i++) {
            len += pieces[i].length;
            if (pieces[i].length == 1) {
                if (index[pieces[i][0]] == -1) {
                    return false;
                }
            }

            int prev = pieces[i][0];
            for (int j = 1; j < pieces[i].length; j++) {
                int pId = index[prev];
                int cId = index[pieces[i][j]];

                if (cId - pId != 1) {
                    return false;
                }

                prev = pieces[i][j];
            }
        }

        return len == arr.length;
    }
}