/*

Given head, the head of a singly linked list, find if the linked list is circular or not. A linked list is called circular if it not NULL terminated and all nodes are connected in the form of a cycle. An empty linked list is considered as circular.

Example 1:
Input:
LinkedList: 1->2->3->4->5
(the first and last node is connected,
i.e. 5 --> 1)
Output: 1

Example 2:
Input:
LinkedList: 2->4->6->7->5->1
Output: 0

Your Task:
The task is to complete the function isCircular() which checks if the given linked list is circular or not. It should return true or false accordingly. (the driver code prints 1 if the returned values is true, otherwise 0)

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <=Number of nodes<= 100

*/


class GfG
{
    boolean isCircular(Node head)
    {
	// Your code here	
	    
	    Node fast = head;
	    Node slow = head;
	    
	    while(fast != null && fast.next != null) {
	        
	        fast = fast.next.next;
	        slow = slow.next;
	        
	        if(fast == slow) {
	            break;
	        }
	    }
	    
	    if(fast == null || fast.next == null) {
	        return false;
	    }
	    
	    return true;
    }
}
