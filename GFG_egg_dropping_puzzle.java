/*

You are given N identical eggs and you have access to a K-floored building from 1 to K.

There exists a floor f where 0 <= f <= K such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break. There are few rules given below. 

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.
Return the minimum number of moves that you need to determine with certainty what the value of f is.

For more description on this problem see wiki page

Example 1:
  Input:
  N = 1, K = 2
  Output: 2
  Explanation: 
    1. Drop the egg from floor 1. If it 
       breaks, we know that f = 0.
    2. Otherwise, drop the egg from floor 2.
       If it breaks, we know that f = 1.
    3. If it does not break, then we know f = 2.
    4. Hence, we need at minimum 2 moves to
       determine with certainty what the value of f is.

Example 2:
  Input:
  N = 2, K = 10
  Output: 4

Your Task:
Complete the function eggDrop() which takes two positive integer N and K as input parameters and returns the minimum number of attempts you need in order to find the critical floor.

Expected Time Complexity : O(N*K)
Expected Auxiliary Space: O(N*K)

Constraints:
1<=N<=200
1<=K<=200

*/


class Solution 
{

    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    int[][] dp = new int[n+1][k+1];
	    for(int i=1; i<=n; i++) {
	        for(int j=1; j<=k; j++) {
	            if(i == 1) {
	                dp[i][j] = j;
	            } else if(j == 1) {
	                dp[i][j] = 1;
	            } else {
	                dp[i][j] = Integer.MAX_VALUE;
	                
	                for(int mj=j-1, pj=0; mj>=0; mj--,pj++) {
	                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][mj], dp[i-1][pj])+1);
	                }
	            }
	        }
	    }
	    
	    return dp[n][k];
	}
}
