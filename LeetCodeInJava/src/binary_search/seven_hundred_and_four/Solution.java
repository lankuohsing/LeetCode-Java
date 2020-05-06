package binary_search.seven_hundred_and_four;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {// 注意是小于等于
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                result = middle;
                break;
            } else {
                if (target < nums[middle]) {
                    right = middle - 1;// 注意要减1
                } else {
                    left = middle + 1;// 注意要加1
                }
            }
        }
        return result;
    }
}
