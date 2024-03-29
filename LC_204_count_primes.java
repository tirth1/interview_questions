/*
Count the number of prime numbers less than a non-negative number, n.
Example 1:
    Input: n = 10
    Output: 4
    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:
    Input: n = 0
    Output: 0
Example 3:
    Input: n = 1
    Output: 0
 
Constraints:
    0 <= n <= 5 * 10^6
*/


class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        
        for(int i=2; i*i<n; i++) {
            if(prime[i] == false) {
                for(int j=i*i; j<n; j+=i) {
                    prime[j] = true;
                }
            }
        }
        
        int count = 0;
        for(int i=2; i<n; i++) {
            if(prime[i]==false) {
                count++;
            }
        }
        
        return count;
    }
}
