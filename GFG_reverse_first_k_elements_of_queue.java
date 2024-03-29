/*

Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, leaving the other elements in the same relative order.

Only following standard operations are allowed on queue.
  enqueue(x) : Add an item x to rear of queue
  dequeue() : Remove an item from front of queue
  size() : Returns number of elements in queue.
  front() : Finds front item.
  
Note: The above operations represent the general processings. In-built functions of the respective languages can be used to solve the problem.

Example 1:
  Input:
    5 3
    1 2 3 4 5
  Output: 3 2 1 4 5
  Explanation: After reversing the given input from the 3rd position the resultant output will be 3 2 1 4 5.

Example 2:
  Input:
    4 4
    4 3 2 1
  Output: 1 2 3 4
  Explanation: After reversing the given input from the 4th position the resultant output will be 1 2 3 4.

Your Task:
Complete the provided function modifyQueue that takes queue and k as parameters and returns a modified queue. The printing is done automatically by the driver code.

Expected Time Complexity : O(n)
Expected Auxiliary Space : O(n)

Constraints:
  1 <= N <= 1000
  1 <= K <= N

Note: The Input/Output format and the Example given are used for the system's internal purpose, and should be used by a user for Expected Output only.
As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.

*/


class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q1 = new LinkedList<>();
        
        while(k-- > 0) {
            st.add(q.poll());
        }
        
        while(!q.isEmpty()) {
            q1.add(q.poll());
        }
        
        while(!st.isEmpty()) {
            q.add(st.pop());
        }
        
        while(!q1.isEmpty()) {
            q.add(q1.poll());
        }
        
        return q;
    }
}
