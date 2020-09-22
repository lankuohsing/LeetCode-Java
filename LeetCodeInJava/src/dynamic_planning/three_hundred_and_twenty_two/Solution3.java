package dynamic_planning.three_hundred_and_twenty_two;

import java.util.Arrays;

class Solution3 {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];// 默认初始化0
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
                }
            }

        }
        return memo[amount] > amount ? -1 : memo[amount];
    }
}
