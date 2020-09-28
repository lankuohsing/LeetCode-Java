package recursion.hanota;

import java.util.List;

public class Solution {
    List<Integer> AA;
    List<Integer> BB;
    List<Integer> CC;

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        AA = A;
        BB = B;
        CC = C;
        moveNFromAToCByB(A.size(), A, B, C);
    }

    private void moveNFromAToCByB(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (A.isEmpty() && B.isEmpty()) {
            return;
        }
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
        } else {
            moveNFromAToCByB(n - 1, A.subList(1, A.size()), C, B);
            C.add(A.remove(A.size() - 1));
            moveNFromAToCByB(n - 1, B, A, C);
        }
    }
}
