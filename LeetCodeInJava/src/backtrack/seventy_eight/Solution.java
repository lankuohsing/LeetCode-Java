package backtrack.seventy_eight;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> oneResult = new ArrayList<Integer>();
    List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return results;
    }

    private void dfs(int start, int[] nums) {
        if (start == nums.length) {
            results.add(new ArrayList<Integer>(oneResult));
            return;
        }
        oneResult.add(nums[start]);// 子集中有on当前元素
        dfs(start + 1, nums);
        oneResult.remove(oneResult.size() - 1);// 子集中无当前元素
        dfs(start + 1, nums);
    }
}
