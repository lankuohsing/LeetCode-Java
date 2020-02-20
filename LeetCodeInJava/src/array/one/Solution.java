package array.one;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        Map<Integer, Integer> numToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i]) && i != numToIndex.get(target - nums[i])) {
                results[0] = nums[i];
                results[1] = numToIndex.get(target - nums[i]);

            }
        }
        return results;
    }
}
