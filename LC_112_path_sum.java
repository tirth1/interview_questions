/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
Note: A leaf is a node with no children.
Example:
Given the below binary tree and sum = 22,
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/


class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            if(targetSum == root.val) {
                return true;
            } 
            return false;
        }
        
        if(root.left != null && hasPathSum(root.left, targetSum-root.val)) {
            return true;
        }

        if(root.right != null && hasPathSum(root.right, targetSum-root.val)) {
            return true;
        }   

        return false;
    }
}
