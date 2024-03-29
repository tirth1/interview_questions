/*

Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

Example 1:
  Input: root = [3,9,20,null,null,15,7]
  Output: [[15,7],[9,20],[3]]

Example 2:
  Input: root = [1]
  Output: [[1]]

Example 3:
  Input: root = []
  Output: []
 
Constraints:
  The number of nodes in the tree is in the range [0, 2000].
  -1000 <= Node.val <= 1000

*/


class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            
            while(size > 0) {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null) {
                    q.add(node.left);
                }
                
                if(node.right != null) {
                    q.add(node.right);
                }
                size--;
            }
            ans.add(0, list);
        }
        
        
        
        return ans;
    }
}
