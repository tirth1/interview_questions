/*

Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:
  The left subtree of a node contains only nodes with keys less than the node's key.
  The right subtree of a node contains only nodes with keys greater than the node's key.
  Both the left and right subtrees must also be binary search trees.

Example 1:
  Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
  Output: 20
  Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.

Example 2:
  Input: root = [4,3,null,1,2]
  Output: 2
  Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.

Example 3:
  Input: root = [-4,-2,-5]
  Output: 0
  Explanation: All values are negatives. Return an empty BST.

Example 4:
  Input: root = [2,1,3]
  Output: 6

Example 5:
  Input: root = [5,4,8,3,null,6,3]
  Output: 7
 
Constraints:
  The number of nodes in the tree is in the range [1, 4 * 10^4].
  -4 * 10^4 <= Node.val <= 4 * 10^4

*/



class Solution {
    class MinMax{
        int min;
        int max;
        boolean isBST;
        int sum;
        MinMax() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isBST = true;
            sum = 0;
        }
    }
    int max = 0;
    public int maxSumBST(TreeNode root) {
        MinMax m = largest(root);
        return max;
    }
    
    public MinMax largest(TreeNode root) {
        if(root == null) {
            return new MinMax();
        }
        
        MinMax left = largest(root.left);
        MinMax right = largest(root.right);
        
        MinMax m = new MinMax();
        
        if(left.isBST == false || right.isBST == false || (left.max > root.val || right.min <= root.val)) {
            m.isBST = false;
            m.sum = Math.max(left.sum, right.sum);
            return m;
        }
        
        m.isBST = true;
        m.sum = left.sum + right.sum + root.val;
        m.min = root.left != null ? left.min : root.val;
        m.max = root.right != null ? right.max : root.val;
        if(m.sum > max) {
            max = m.sum;
        }
        return m;
    }
}
