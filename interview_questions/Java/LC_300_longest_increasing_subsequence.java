/*

Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
 
Constraints:
1 <= nums.length <= 2500
-10^4 <= nums[i] <= 10^4
 
Follow up:
Could you come up with the O(n2) solution?
Could you improve it to O(n log(n)) time complexity?

*/


// Dynamic Programming O(n^2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return 1;
        }
        int[] dp = new int[len];
        dp[0] = 0;
        for(int i=1; i<len; i++) {
       
            for(int j=i-1; j>=0; j--) {
                if(nums[j] < nums[i]) {
                    if(dp[i] <= dp[j]) {
                        dp[i] = dp[j]+1;
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<len; i++) {
            if(max < dp[i]) {
                max = dp[i];
            }
        }
        
        return max+1;
    }
}