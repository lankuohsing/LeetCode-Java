package binary_search.find_left_right_index;

public class Main {
    public static void main(String[] args) {
//        int[] nums = { 1, 2, 3, 3, 3, 4, 5 };
//        int[] nums = { 1, 2, 4, 4, 4, 4, 5 };
//        int[] nums = { 1, 2, 3, 3, 3, 3, 3 };
        int[] nums = { 1 };
        int target = 0;
        Solution solution = new Solution();
        int left = solution.findLeftIndex(nums, target);
        System.out.println("最终的left:" + left);
        int right = solution.findRightIndex(nums, target);
        System.out.println("最终的right:" + right);

    }
}
