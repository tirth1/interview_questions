/*

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
  Input: root = [1,null,2,3]
  Output: [1,3,2]

Example 2:
  Input: root = []
  Output: []

Example 3:
  Input: root = [1]
  Output: [1]

Example 4:
  Input: root = [1,2]
  Output: [2,1]

Example 5:
  Input: root = [1,null,2]
  Output: [1,2]
 
Constraints:
  The number of nodes in the tree is in the range [0, 100].
  -100 <= Node.val <= 100
 
Follow up: Recursive solution is trivial, could you do it iteratively?

*/


// Iteratively
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        while(root!=null || !st.empty()) {   
            if(root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                ans.add(root.val);
                root = root.right;
            }
        }   
        return ans;
    }
}


// Recursive
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) {
            return ans;
        }
        inorderTraversal(root, ans);
        return ans;
    }
    
    void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            inorderTraversal(root.left, list);
        }
        
        list.add(root.val);
        
        if(root.right != null) {
            inorderTraversal(root.right, list);
        }
    }
}
