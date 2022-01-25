/*

Implement a Stack using two queues q1 and q2.

Example 1:
  Input:
    push(2)
    push(3)
    pop()
    push(4)
    pop()
  Output: 3 4
  Explanation:
    push(2) the stack will be {2}
    push(3) the stack will be {2 3}
    pop()   poped element will be 3 the stack will be {2}
    push(4) the stack will be {2 4}
    pop()   poped element will be 4  

Example 2:
  Input:
    push(2)
    pop()
    pop()
    push(3)
  Output: 2 -1

Your Task:
Since this is a function problem, you don't need to take inputs. You are required to complete the two methods push() which takes an integer 'x' as input denoting 
the element to be pushed into the stack and pop() which returns the integer poped out from the stack(-1 if the stack is empty).

Expected Time Complexity: O(1) for push() and O(N) for pop() (or vice-versa).
Expected Auxiliary Space: O(1) for both push() and pop().

Constraints:
1 <= Number of queries <= 100
1 <= values of the stack <= 100

*/


class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    void push(int a)
    {
	    // Your code here	
	    q1.add(a);
    }
    
    //Function to pop an element from stack using two queues. 
    int pop()
    {
	    // Your code here
	    if(q1.isEmpty()) {
	        return -1;
	    }
	    
	    int val = q1.poll();
	    while(!q1.isEmpty()) {
	        q2.add(val);
	        val = q1.poll();
	    }
	    
	    while(!q2.isEmpty()) {
	        q1.add(q2.poll());
	    }
	    
	    return val;
    }
	
}
