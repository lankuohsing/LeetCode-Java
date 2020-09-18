package recursion.fibonacci;

class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        long[] memo = new long[n];
        return (int) ((helper(n - 1, memo) + helper(n - 2, memo)) % 1000000007);
    }

    private long helper(int n, long[] memo) {
        if (n < 2) {
            return (long) n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = (helper(n - 1, memo) + helper(n - 2, memo)) % 1000000007;
        return memo[n];
    }
}
