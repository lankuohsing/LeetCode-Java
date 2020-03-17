package topk_problem;

public class TopKProblem {
    public static void main(String[] args) {
//      int[] a = { 1, 6, 8, 7, 3, 5, 16, 4, 8, 36, 13, 44 };
        int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int k = 3;
        topKByBubleSort(a, k);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }

    }

    // 采用改良的冒泡法，复杂度O(nlogk)
    public static void topKByBubleSort(int[] array, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
}
