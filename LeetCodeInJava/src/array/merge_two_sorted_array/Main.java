package array.merge_two_sorted_array;

public class Main {
    public static void main(String[] args) {
        int[] A = { 4, 5, 6, 0, 0, 0 };
        int m = 3;
        int[] B = { 1, 2, 3 };
        int n = 3;
        Solution solution = new Solution();
        solution.merge(A, m, B, n);
        for (int i : A) {
            System.out.print(i + ", ");
        }
    }
}
