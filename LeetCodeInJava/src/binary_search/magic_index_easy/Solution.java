package binary_search.magic_index_easy;

/*
魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。
若有多个魔术索引，返回索引值最小的一个。
这里考虑简单情形，即数组中没有重复元素（严格单调递增数组）
 */
public class Solution {
    public int findMagicIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] >= middle) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (left == nums.length || nums[left] != left) {
            left = -1;
        }
        return left;
    }
}
