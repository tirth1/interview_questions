/*

Given an array arr[] of N integers, calculate the median

Example 1:
  Input: N = 5
  arr[] = 90 100 78 89 67
  Output: 89
  Explanation: After sorting the array middle element is the median 

Example 2:
  Input: N = 4
  arr[] = 56 67 30 79
  Output: 61
  Explanation: In case of even number of 
  elements, average of two middle elements is the median.

Your Task:
You don't need to read or print anything. Your task is to complete the function find_median() which takes the array as input parameter and returns the floor value of the median.
 
Expected Time Complexity: O(n * log(n))
Expected Space Complexity: O(1)
 
Constraints:
1 <= Length of Array <= 100
1 <= Elements of Array <= 100

*/


class Solution
{
    public int find_median(int[] v)
    {
        // Code here
        Arrays.sort(v);
        int len = v.length;
        if(len%2 == 0) {
            return (v[len/2] + v[(len/2)-1])/2;
        }
        
        return v[(len/2)];
    }
}
