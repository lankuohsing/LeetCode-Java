package binary_search.seven_hundred_and_forty_four;

public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // 循环继续的条件：start <= end
        // 更新start的条件：nums[middle] <= target
        // 如果target不存在，最终start为第一个大于target的下标（如果没有大于target的，就等于nums.length）
        // 如果target存在，最终start为最右边那个下标+1

        int start = 0;
        int end = letters.length - 1, middle;
        while (start <= end) {
            middle = (start + end) / 2;
            if (letters[middle] <= target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        int right = start;
        return letters[right % letters.length];
    }
}
