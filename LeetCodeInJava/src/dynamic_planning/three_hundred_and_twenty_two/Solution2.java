package dynamic_planning.three_hundred_and_twenty_two;

/*
leetode-322
给定不同面额的硬币 coins 和一个总金额 amount。
编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
如果没有任何一种硬币组合能组成总金额，返回 -1。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
从后往前递归，用数组存储中间结果，index是amount，value是result
 */
public class Solution2 {
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];// 默认初始化0
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != 0) {
            return memo[amount];
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
            memo[amount] = -1;
        } else {
            memo[amount] = result;
        }
        return memo[amount];
    }
}
