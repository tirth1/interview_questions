/*

You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).

Example 1:
  Input:
    N = 3
    W = 4
    values[] = {1,2,3}
    weight[] = {4,5,1}
  Output: 3

Example 2:
  Input:
    N = 3
    W = 3
    values[] = {1,2,3}
    weight[] = {4,5,6}
  Output: 0

Your Task:
Complete the function knapSack() which takes maximum capacity W, weight array wt[], value array val[], and the number of items n as a parameter and returns the maximum possible value you can get.

Expected Time Complexity: O(N*W).
Expected Auxiliary Space: O(N*W)

Constraints:
  1 ≤ N ≤ 1000
  1 ≤ W ≤ 1000
  1 ≤ wt[i] ≤ 1000
  1 ≤ v[i] ≤ 1000

*/


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[n+1][W+1];
         
         for(int i=1; i<=n; i++) {
             for(int j=1; j<=W; j++) {
                 if(j >= wt[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]);    
                 } else {
                     dp[i][j] = dp[i-1][j];
                 }
             }
         }
         
         return dp[n][W];
    } 
}
