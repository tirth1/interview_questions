/*

Given a Binary search Tree that contains positive integer values greater then 0. The task is to complete the function isDeadEnd which returns true if the BST contains a dead end else returns false. Here Dead End means, we are not able to insert any element after that node.

Examples:
Input :   
               8
             /   \ 
           5      9
         /  \     
        2    7 
       /
      1     
          
Output : Yes
Explanation : Node "1" is the dead End because after that 
              we cant insert any element.       

Input :     
              8
            /   \ 
           7     10
         /      /   \
        2      9     13

Output : Yes
Explanation : We can't insert any element at 
              node 9.  

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of three lines. First line of each test case contains an integer N denoting the no of nodes of the BST . Second line of each test case consists of 'N' space separated integers denoting the elements of the BST. These elements are inserted into BST in the given order.

Output:
The output for each test case will be 1 if the BST contains a dead end else 0.

Constraints:
1<=T<=100
1<=N<=200
 
Example(To be used only for expected output):
  Input:
    2
    6
    8 5 9 7 2 1
    6
    8 7 10 9 13 2
  Output:
    1
    1

*/


class GFG
{
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        return isDeadEnd(root, Integer.MAX_VALUE, 1);
    }
    
    public static boolean isDeadEnd(Node root, int max, int min) {
        if(root == null) {
            return false;
        }
        
        if(max == min) {
            return true;
        }
        
        return isDeadEnd(root.left, root.data-1, min) || isDeadEnd(root.right, max, root.data+1);
    }
    
    
}
