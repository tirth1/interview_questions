/*

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
  Input: coins = [1,2,5], amount = 11
  Output: 3
  Explanation: 11 = 5 + 5 + 1

Example 2:
  Input: coins = [2], amount = 3
  Output: -1

Example 3:
  Input: coins = [1], amount = 0
  Output: 0

Example 4:
  Input: coins = [1], amount = 1
  Output: 1

Example 5:
  Input: coins = [1], amount = 2
  Output: 2
 
Constraints:
  1 <= coins.length <= 12
  1 <= coins[i] <= 2^31 - 1
  0 <= amount <= 10^4

*/



class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=1; j<=amount; j++) {
                if(coins[i] <= j) {
                    dp[j] = Math.min(dp[j], 1+dp[j-coins[i]]);
                }
            }
        }
        
        return dp[amount] >= 100001 ? -1 : dp[amount];
    }
}




class Solution {
   
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i == coin) {
                    dp[i] = 1;
                } else if (i > coin) {
                    if (dp[i - coin] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                    }
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[amount];
    }
}
