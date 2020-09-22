package dynamic_planning.three_hundred_and_twenty_two;

public class Main {
    public static void main(String[] args) {
        int[] coins = { 2, 6, 10, 1 };
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Solution3().coinChange(coins, 27));
    }
}
