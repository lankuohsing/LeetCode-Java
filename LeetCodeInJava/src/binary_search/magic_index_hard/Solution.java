package binary_search.magic_index_hard;

/*
魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。
若有多个魔术索引，返回索引值最小的一个。
这里考虑复杂情形，即数组中可能有重复元素
 */
public class Solution {
    public int findMagicIndex(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        int answer = getAnswer(nums, left, middle - 1);
        if (answer != -1) {
            return answer;
        } else {
            if (middle == nums[middle]) {
                return middle;
            }
        }
        return getAnswer(nums, middle + 1, right);
    }
}
