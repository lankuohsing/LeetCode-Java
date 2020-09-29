package backtrack.seventy_seven;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> oneResult = new ArrayList<Integer>();
    List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return results;
    }

    private void dfs(int start, int n, int k) {
        if (n - start + 1 < k - oneResult.size()) {
            return;// 剪枝
        }
        if (start > n) {
            if (oneResult.size() == k) {
                results.add(new ArrayList<Integer>(oneResult));
            }
            return;
        }
        oneResult.add(start);
        dfs(start + 1, n, k);
        oneResult.remove(oneResult.size() - 1);
        dfs(start + 1, n, k);
    }
}