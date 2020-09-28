package backtrack.seventy_eight;

import java.util.ArrayList;
import java.util.List;

public class Solution0 {
    List<Integer> oneResult = new ArrayList<Integer>();
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    Boolean[] decisions = { true, false };// 选择列表

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return results;
    }

    private void dfs(int start, int[] nums) {
        if (start == nums.length) {
            results.add(new ArrayList<Integer>(oneResult));
            return;
        }
        for (Boolean decision : decisions) {
            if (decision) {
                oneResult.add(nums[start]);// 子集中有当前元素
            }
            dfs(start + 1, nums);
            for (int i = 0; i < oneResult.size(); i++) {
                if (oneResult.get(i) == nums[start]) {
                    oneResult.remove(i);
                    i--;
                }
            }
        }

    }
}
