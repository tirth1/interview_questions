/*

A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.

Example 1:
  Input:
  LinkedList: 4->5->6
  Output: 457 

Example 2:
  Input:
  LinkedList: 1->2->3
  Output: 124 

Your Task:
Your task is to complete the function addOne() which takes the head of the linked list as the only argument and returns the head of the modified linked list. The driver code prints the number.

Note: The head represents the left-most digit of the number.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 10^1000

*/


class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        if(head.next == null) {
            head.data += 1;
            return head;
        }
        
        Node sum = addOne(head.next);
        head.data = head.data + (sum.data /10);
        sum.data = sum.data % 10;
        
        return head;
    }
}
