package binary_search.fifty_three;

public class Solution {
    public int search(int[] nums, int target) {
        return findRightIndex(nums, target) - findLeftIndex(nums, target);
    }

    public int findLeftIndex(int nums[], int target) {
        // 循环继续的条件：start <= end
        // 更新start的条件：nums[middle] < target
        // 如果target不存在，最终start为第一个大于target的下标（如果没有大于target的，就等于nums.length）
        // 如果target存在，最终start为最左边那个下标
        if (nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1, middle;
        while (start <= end) {
            middle = (start + end) / 2;
            if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        int left = start;
        if (left == nums.length || nums[left] != target) {
            left = -1;
        }
        return left;
    }

    public int findRightIndex(int nums[], int target) {
        // 循环继续的条件：start <= end
        // 更新start的条件：nums[middle] <= target
        // 如果target不存在，最终start为第一个大于target的下标（如果没有大于target的，就等于nums.length）
        // 如果target存在，最终start为最右边那个下标+1
        if (nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1, middle;
        while (start <= end) {
            middle = (start + end) / 2;
            if (nums[middle] <= target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        int right = start;
        if (right == nums.length) {
            if (nums[right - 1] != target) {
                right = -1;
            }
        } else {
            if (right - 1 < 0 || nums[right - 1] != target) {
                right = -1;
            }
        }
        return right;
    }
}