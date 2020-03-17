package useful_codes.sort;

public class BubbleSort {
    public static void main(String[] args) {
//      int[] a = { 1, 6, 8, 7, 3, 5, 16, 4, 8, 36, 13, 44 };
        int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        bubleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }

    }

    public static void bubleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
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
