/*

Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

Example 1:
  Input: preorder = [8,5,1,7,10,12]
  Output: [8,5,10,1,7,null,12]

Example 2:
  Input: preorder = [1,3]
  Output: [1,null,3]
 
Constraints:
  1 <= preorder.length <= 100
  1 <= preorder[i] <= 10^8
  All the values of preorder are unique.

*/


// Recursion
class Solution {
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    TreeNode helper(int[] preorder, int lower, int upper) {
        if(idx == preorder.length) {
            return null;
        }
        
        int val = preorder[idx];
        if(val < upper && val > lower) {
            TreeNode root = new TreeNode(val);
            idx++;
            root.left = helper(preorder, lower, val);
            root.right = helper(preorder, val, upper);
            return root;
        }
        
        return null;
    }
}



class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length-1);
    }
    
    TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if(start > end) {
            return null;
        }
        
        int val = preorder[start];
        TreeNode root = new TreeNode(val);
        
        int idx = start+1;
        while(idx<=end && preorder[idx] < val) {
            idx++;
        }
        
        root.left = bstFromPreorder(preorder, start+1, idx-1);
        root.right = bstFromPreorder(preorder, idx, end);
        
        return root;
    }
}



// Iteratively
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        
        for(int i=1; i<preorder.length; i++) {
            TreeNode curr = root;
            boolean inserted = false;
            
            while(!inserted) {
                if(preorder[i] < curr.val && curr.left == null) {
                    inserted = true;
                    curr.left = new TreeNode(preorder[i]);
                } else if(preorder[i] > curr.val && curr.right == null) {
                    inserted = true;
                    curr.right = new TreeNode(preorder[i]);
                } else if(preorder[i] < curr.val) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
        }
        return root;
    }
}
