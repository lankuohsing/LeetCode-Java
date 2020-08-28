package binary_search.magic_index_easy;

public class Main {
    public static void main(String[] args) {
//        int[] nums = { 1, 2, 3, 3, 3, 4, 5 };
//        int[] nums = { 1, 2, 4, 4, 4, 4, 5 };
//        int[] nums = { 1, 2, 3, 3, 3, 3, 3 };
        int[] nums = { -1, 0, 2, 3, 4 };
        Solution solution = new Solution();
        int left = solution.findMagicIndex(nums);
        System.out.println("最终的left:" + left);

    }
}
