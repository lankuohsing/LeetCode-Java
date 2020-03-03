package array.merge_two_sorted_array;

/*
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。

初始化 A 和 B 的元素数量分别为 m 和 n。

示例:

输入:
A = [1,2,3,0,0,0], m = 3
B = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

链接：https://leetcode-cn.com/problems/sorted-merge-lcci

 */
public class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < n; i++) {
            A[m + i] = B[i];
        }
        for (int i = m; i < m + n; i++) {
            int k = i;
            for (int j = k - 1; j >= 0; j--) {
                if (A[j] > A[k]) {
                    int temp = A[k];
                    A[k] = A[j];
                    A[j] = temp;
                    k = j;
                } else {
                    break;
                }
            }
        }
    }
}
