package dynamic_planning.three_hundred_and_twenty_two;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subResult = dp(coins, amount - coin);
            if (subResult < 0) {
                continue;
            }
            result = Math.min(result, 1 + subResult);
        }
        if (result == Integer.MAX_VALUE) {
            memo.put(amount, -1);
        } else {
            memo.put(amount, result);
        }
        return memo.get(amount);
    }
}
