import java.util.List;


class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dims = binaryMatrix.dimensions();
        int row = dims.get(0);
        int col = dims.get(1);

        int result = -1;

        for (int i = 0; i < row; i++) {
            int st = 0, end = col - 1;
            while (st < end) {
                int mid = (st + end) / 2;
                int midV = binaryMatrix.get(i, mid);

                if (midV == 0) {
                    st = mid + 1;
                } else {
                    end = mid;
                }
            }

            if (binaryMatrix.get(i, st) == 1) {
                result = result == -1 ? st : Math.min(result, st);
            }

        }

        return result;
    }
}