/*

Given a doubly linked list of n elements. The task is to reverse the doubly linked list.

Example 1:
  Input:
  LinkedList: 3 <--> 4 <--> 5
  Output: 5 4 3

Example 2:
  Input:
  LinkedList: 75 <--> 122 <--> 59 <--> 196
  Output: 196 59 122 75

Your Task:
Your task is to complete the given function reverseDLL(), which takes head reference as argument and should reverse the elements so that the tail becomes the new head and all pointers are correctly pointed. You need to return the new head of the reversed list. The printing and verification is done by the driver code.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 <= number of nodes <= 10^3
0 <= value of nodes <= 10^3

*/


public static Node reverseDLL(Node  head)
{
    //Your code here
    Node curr = head;
    if(head == null || head.next == null) {
        return head;
    }
    
    while(curr.next != null) {
        curr = curr.next;
    }
    head = curr;
    
    curr.next = curr.prev;
    curr.prev = null;
    curr = curr.next;
    
    while(curr.prev != null) {
        Node temp = curr.next;
        curr.next = curr.prev;
        curr.prev = temp;
        
        curr = curr.next;
    }
    
    curr.prev = curr.next;
    curr.next = null;
    
    return head;
}
