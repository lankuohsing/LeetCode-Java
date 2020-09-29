package backtrack.forty_six;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> oneResult = new ArrayList<Integer>();
    List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        int[] isUsed = new int[nums.length];
        dfs(nums, isUsed);
        return results;
    }

    private void dfs(int[] nums, int[] isUsed) {
        Boolean allIsUsed = true;
        for (int i = 0; i < isUsed.length; i++) {
            if (isUsed[i] == 0) {
                allIsUsed = false;
                oneResult.add(nums[i]);
                isUsed[i] = 1;
                dfs(nums, isUsed);
                oneResult.remove(oneResult.size() - 1);
                isUsed[i] = 0;
            }
        }
        if (allIsUsed) {
            results.add(new ArrayList<Integer>(oneResult));
            return;
        }
    }
}
