/*

Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

Example 1:
  Input: s = "abc"
  Output: 3
  Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
  Input: s = "aaa"
  Output: 6
  Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 
Constraints:
  1 <= s.length <= 1000
  s consists of lowercase English letters.

*/


// time complexity O(n^3) Space Complexity O(n)
class Solution {
    public int countSubstrings(String s) {
        int count = s.length();
        char[] ch = s.toCharArray();
        for(int i=0; i<s.length(); i++) {
            count += checkPalindrome(ch, i-1, i);
            count += checkPalindrome(ch, i-1, i+1);
        }
        return count;
    }
    
    int checkPalindrome(char[] ch, int start, int end) {
        int i = start;
        int j = end;
        int count=0;
        while(i>=0 && j<ch.length && ch[i]==ch[j]) {
            count++;
            i--;
            j++;
        }
        return count;
    }
}


// Dynamic Programming
// time complexity O(n^2) and Space Complexity O(n^2)
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(i == j) {
                    dp[i][j] = true;
                } else if(i+1 == j) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
                
                if(dp[i][j]) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
