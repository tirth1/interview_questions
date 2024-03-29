/*

Given a Binary search tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.


Example 1:
  Input:
        4
      /   \
     2     9
  k = 2 
  Output: 4

Example 2:
  Input:
         9
          \ 
            10
  K = 1
  Output: 10

Your Task: 
  Your task is to complete the function kthLargest() which takes the root of the BST and an integer K as inputs and returns the Kth largest element in the given BST.

Expected Time Complexity: O(H + K).
Expected Auxiliary Space: O(H)

Constraints:
  1 <= N <= 1000
  1 <= K <= N

*/



class Solution
{
    int gK;
    public int kthLargest(Node root,int K)
    {
        gK = K;
        return helper(root);
    }
    
    int helper(Node root) {
        if(root == null) {
            return 0;
        }
        
        int right = helper(root.right);
        if(right != 0 ){
            return right;
        }
        gK--;
        if(gK == 0) {
            return root.data;
        }
        int left = helper(root.left);
        return left;
    }
}
