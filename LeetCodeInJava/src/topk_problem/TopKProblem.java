package topk_problem;

public class TopKProblem {
    public static void main(String[] args) {
//        int[] a = { 1, 6, 8, 7, 3, 5, 16, 4, 8, 36, 13, 44 };
        int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//        int[] a = { 1, 6, 8, 7, 3, 5, 16, 4 };
        int k = 3;
//        topKByBubleSort(a, k);
//        topKByQuickSort(a, 0, a.length - 1, k);
        topKSByQuickSort(a, 0, a.length - 1, k);
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

    private static int partion(int[] array, int start, int end) {

        // 指定左哨兵和右哨兵
        int left = start;
        int right = end;
        // 指定基准元素
        int base = array[left];
        // 使用循环实现分区操作
        while (left < right) {
            // 1.从右向左移动right，找到第一个小于基准值的值array[right]
            while (array[right] >= base && left < right) {
                right -= 1;
            }
            // 2.找到了小于基准值的值，将它放入左边的位置。左哨兵右移一个位置
            // 注意若left==right则说明没找到
            if (left < right) {
                array[left] = array[right];
                left += 1;
                System.out.println("swap");
            }
            // 3.从左向右移动left，找到第一个大于等于基准值的array[left]
            while (array[left] < base && left < right) {
                left += 1;
            }
            // 4.找到了大于等于基准值的值放到右侧的位置。右哨兵左移一个位置
            if (left < right) {
                array[right] = array[left];
                right -= 1;
                System.out.println("swap");
            }
        }
        // 上面的循环结束时，left==right
        array[left] = base;
        return left;
    }

    // 采用改良的冒泡法，复杂度O(n)
    public static void topKByQuickSort(int[] array, int start, int end, int k) {

        if (start < end) {
            // 分区操作，将一个数组分成两个分区，返回分区界限下标
            int index = partion(array, start, end);
//            System.out.println(index);
            // 第k小的数在左分区
            if (index > k - 1) {
                // 对左分区进行快排
                topKByQuickSort(array, start, index - 1, k);
            } else {
                // 第k小的数在右分区
                if (index < k - 1) {
                    // 对右分区进行快排
                    topKByQuickSort(array, index + 1, end, k);
                }

            }

        }
    }

    // 采用改良的冒泡法，复杂度O(n)
    public static void topKSByQuickSort(int[] array, int start, int end, int k) {

        if (start < end) {
            // 分区操作，将一个数组分成两个分区，返回分区界限下标
            int index = partion(array, start, end);
            System.out.println(index);
            // 第k小的数在左分区
            if (index > k - 1) {
                // 对左分区进行快排
                topKSByQuickSort(array, start, index - 1, k);
            } else {
                // 第k小的数在右分区
                if (index <= k - 1) {
                    // 对左分区进行快排
                    topKSByQuickSort(array, start, index - 1, k);
                    // 对右分区进行快排
                    topKSByQuickSort(array, index + 1, end, k);
                }

            }

        }
    }
}
