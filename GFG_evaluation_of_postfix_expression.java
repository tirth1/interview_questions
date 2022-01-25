/*

Given string S representing a postfix expression, the task is to evaluate the expression and find the final value. Operators will only include the basic arithmetic operators like *, /, + and -.

Example 1:
  Input: S = "231*+9-"
  Output: -4
  Explanation: After solving the given expression, we have -4 as result.
  
Example 2:
  Input: S = "123+*8-"
  Output: -3
  Explanation: After solving the given postfix expression, we have -3 as result.

Your Task:
You do not need to read input or print anything. Complete the function evaluatePostfixExpression() that takes the string S denoting the expression as input parameter and returns the evaluated value.

Expected Time Complexity: O(|S|)
Expected Auixilliary Space: O(|S|)

Constraints:
1 ≤ |S| ≤ 10^5
0 ≤ |Si|≤ 9 (And given operators)

*/


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> stack = new Stack<>();
        
        for(char ch : S.toCharArray()) {
            if(ch == '*') {
                int val1 = stack.pop();
                int val2 = stack.pop();
                
                stack.add(val1 * val2);
            } else if(ch == '/') {
                int val1 = stack.pop();
                int val2 = stack.pop();
                
                stack.add(val2 / val1);
            } else if(ch == '+') {
                int val1 = stack.pop();
                int val2 = stack.pop();
                
                stack.add(val1 + val2);
            } else if(ch == '-') {
                int val1 = stack.pop();
                int val2 = stack.pop();
                
                stack.add(val2 - val1);
            } else {
                stack.push(ch-'0');
            }
        }
        
        return stack.pop();
    }
}
