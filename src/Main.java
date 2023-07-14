import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static String getBitMask(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2 == 0 ? '0' : '1');
            n = n / 2;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();


        System.out.println(solution.totalHammingDistance(new int[]{4, 14, 2}));
    }
}
