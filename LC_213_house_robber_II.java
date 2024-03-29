/*

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
  Input: nums = [2,3,2]
  Output: 3
  Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:
  Input: nums = [1,2,3,1]
  Output: 4
  Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.

Example 3:
  Input: nums = [1,2,3]
  Output: 3
 
Constraints:
  1 <= nums.length <= 100
  0 <= nums[i] <= 1000

*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        } else if(n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        return Math.max(helper(nums, 0, n-1), helper(nums, 1, n));
    }
    
    int helper(int[] nums, int start, int end) {
        
        int prev1 = nums[end-2];
        int prev2 = nums[end-1];
        int prev3 = 0;
        
        for(int i=end-3; i>=start; i--) {
            int temp = Math.max(prev2, prev3) + nums[i];
            prev3 = prev2;
            prev2 = prev1;
            prev1 = temp;
        }
        
        return Math.max(prev1, prev2);
    }
}




class Solution {
    Integer[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new Integer[n];
        return Math.max(helper(nums, 0, n-1), helper(nums, 1, n));
    }
    
    int helper(int[] nums, int start, int end) {
        if(start >= end) {
            return 0;
        }
        
        if(dp[start] != null) {
            return dp[start];
        }
        
        dp[start] = Math.max(helper(nums, start+1, end), nums[start]+helper(nums, start+2, end));
        return dp[start];
    }
}
