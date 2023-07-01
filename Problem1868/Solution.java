import java.util.*;

class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {

        if (encoded1 == null || encoded1.length == 0 || encoded2 == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        int prev = -1;
        int currentCount = 0;
        int oneCnt = 0, twoCnt = 0;
        int i = 0, j = 0;

        while (i < encoded1.length) {
            int curr =  encoded1[i][0] * encoded2[j][0];
            int count = Math.min(encoded1[i][1] - oneCnt, encoded2[j][1] - twoCnt);
            oneCnt+=count;
            twoCnt+=count;

            if (prev != curr) {
                if (prev != -1) {
                    result.add(List.of(prev, currentCount));
                }
                currentCount = 0;
            }

            prev = curr;
            currentCount += count;

            if (encoded1[i][1] == oneCnt) {
                oneCnt = 0;
                i++;
            }

            if (encoded2[j][1] == twoCnt) {
                twoCnt = 0;
                j++;
            }
        }

        result.add(List.of(prev, currentCount));

        return result;
    }
}