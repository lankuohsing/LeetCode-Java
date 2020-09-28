package backtrack.seventy_eight;

import java.util.ArrayList;
import java.util.List;

/*
回溯算法的模板
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
 */
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
        for (Boolean decision : decisions) {// 对选择列表的各个选择进行一一尝试
            if (decision) {
                oneResult.add(nums[start]);// 子集中有当前元素
            }
            dfs(start + 1, nums);
            for (int i = 0; i < oneResult.size(); i++) {
                if (oneResult.get(i) == nums[start]) {
                    oneResult.remove(i);// 撤销选择
                    i--;
                }
            }
        }

    }
}
