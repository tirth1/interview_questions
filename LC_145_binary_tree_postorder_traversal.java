/*

Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:
  Input: root = [1,null,2,3]
  Output: [3,2,1]

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
  Output: [2,1]
 
Constraints:
  The number of the nodes in the tree is in the range [0, 100].
  -100 <= Node.val <= 100
 
Follow up: Recursive solution is trivial, could you do it iteratively?

*/



// Iteratively
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.empty()) {
            TreeNode cur = st.pop();
            ans.add(0, cur.val);
            if(cur.left != null) {
                st.push(cur.left);
            }
            if(cur.right != null) {
                st.push(cur.right);
            }
        }
        
        return ans;
    }
}



// Recursive
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) {
            return ans;
        }
        postorderTraversal(root, ans);
        return ans;
    }
    
    void postorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        
        if(root.left != null) {
            postorderTraversal(root.left, list);
        }
        
        if(root.right != null) {
            postorderTraversal(root.right, list);
        }
        
        list.add(root.val);
    }
}
