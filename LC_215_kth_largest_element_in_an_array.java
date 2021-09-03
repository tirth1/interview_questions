/*

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
  Input: nums = [3,2,1,5,6,4], k = 2
  Output: 5

Example 2:
  Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
  Output: 4
 
Constraints:
1 <= k <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4

*/



class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<nums.length; i++) {
            p.add(nums[i]);
        }
        
        for(int i=0; i<k-1; i++) {
            p.poll();
        }
        return p.poll();
    }
}