

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class Solution
{
    public int[] anagramMappings(int[] A, int[] B)
    {
        int[] result = new int[A.length];
        Map<Integer, List<Integer>> indicesByNumber = new HashMap<>();
        IntStream.range(0, B.length).boxed().forEach(i -> indicesByNumber.computeIfAbsent(B[i],
                k -> new ArrayList<>()).add(i));
        IntStream.range(0, A.length).boxed().forEach(i -> result[i] = indicesByNumber.get(A[i]).remove(0));
        return result;
    }
}