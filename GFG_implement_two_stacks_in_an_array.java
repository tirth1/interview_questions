/*

Your task is to implement  2 stacks in one array efficiently.

Example 1:
  Input:
    push1(2)
    push1(3)
    push2(4)
    pop1()
    pop2()
    pop2()
  Output:
  3 4 -1
  Explanation:
    push1(2) the stack1 will be {2}
    push1(3) the stack1 will be {2,3}
    push2(4) the stack2 will be {4}
    pop1()   the poped element will be 3 from stack1 and stack1 will be {2}
    pop2()   the poped element will be 4 from stack2 and now stack2 is empty
    pop2()   the stack2 is now empty hence -1 .

Your Task:
You don't need to read input or print anything. You are required to complete the 4 methods push1, push2 which takes one argument an integer 'x' to be pushed 
into stack one and two and pop1, pop2 which returns the integer poped out from stack one and two. If no integer is present in the array return -1.

Expected Time Complexity: O(1) for all the four methods.
Expected Auxiliary Space: O(1) for all the four methods.

Constraints:
  1 <= Number of queries <= 100
  1 <= value in the stack <= 100
  The sum of elements in both the stacks < size of the given array

*/


class Stacks
{
    //Function to push an integer into the stack1.
    void push1(int x, TwoStack sq)
    {
        sq.arr[++sq.top1] = x;
    }

    //Function to push an integer into the stack2.
    void push2(int x, TwoStack sq)
    {
        sq.arr[--sq.top2] = x;
    }

    //Function to remove an element from top of the stack1.
    int pop1(TwoStack sq)
    {
        if(sq.top1 == -1) {
            return -1;
        }
        return sq.arr[sq.top1--];
    }

    //Function to remove an element from top of the stack2.
    int pop2(TwoStack sq)
    {
        if(sq.top2 == sq.size) {
            return -1;
        }
        return sq.arr[sq.top2++];
    }
}

