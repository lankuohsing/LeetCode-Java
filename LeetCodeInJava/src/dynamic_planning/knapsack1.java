package dynamic_planning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 0/1背包问题
 * 问题描述：有n件物品和容量为m的背包 给出i件物品的重量以及价值 求解让装入背包的物品重量不超过背包容量 且价值最大 。
 * 特点:这是最简单的背包问题，特点是每个物品只有一件供你选择放还是不放。
 * https://zhuanlan.zhihu.com/p/30959069
 * https://blog.csdn.net/huanghanqian/article/details/79810850
 */
public class knapsack1 {
    public static void main(String[] args) {
        int maxWeight = 11;
        int numItems = 5;
        // {重量，价值},最优价值为40
        int[][] items = { { 1, 1 }, { 2, 6 }, { 5, 18 }, { 6, 22 }, { 7, 28 } };
        int[][] f = new int[numItems + 1][maxWeight + 1];
        List<Integer> results = new ArrayList<Integer>(Arrays.asList(new Integer[numItems]));
        int maxValue = twoDimensionSolution(maxWeight, numItems, items, f);
        int j = maxWeight;
        // 回溯法确定哪些物品需要选
        for (int i = numItems; i > 0; i--) {
            // 第i个物品放进来是有作用的，说明要选第i个物品
            if (f[i][j] > f[i - 1][j]) {
                results.set(i - 1, 1);
                j -= items[i - 1][0];// 减去第i个物品的重量
            } else {
                results.set(i - 1, 0);
            }
        }
        System.out.println(maxValue);
        System.out.println(results);
    }

    public static int twoDimensionSolution(int maxWeight, int numItems, int[][] items, int[][] f) {
        for (int i = 0; i <= numItems; i++) {
            f[i][0] = 0;
        }
        for (int j = 0; j <= maxWeight; j++) {
            f[0][j] = 0;
        }
        for (int i = 1; i <= numItems; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                // 第i个物品的重量大于总重量
                if (items[i - 1][0] > j) {
                    f[i][j] = f[i - 1][j];
                } else {
                    // 第i个物品不要。注：i从1开始计数
                    if (f[i - 1][j] > f[i - 1][j - items[i - 1][0]] + items[i - 1][1]) {
                        f[i][j] = f[i - 1][j];
                    } else {// 第i个物品要。注：i从1开始计数
                        f[i][j] = f[i - 1][j - items[i - 1][0]] + items[i - 1][1];

                    }

                }
            }
        }
//        System.err.println(totalTimes);
        return f[numItems][maxWeight];
    }

}
