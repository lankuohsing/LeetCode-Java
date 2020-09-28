package recursion.hanota;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(3, 2, 1, 0));
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        new Solution().hanota(A, B, C);

        System.out.println(C);

    }
}
