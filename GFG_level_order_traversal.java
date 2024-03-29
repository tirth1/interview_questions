/*

Given a binary tree, find its level order traversal.
Level order traversal of a tree is breadth-first traversal for the tree.

Example 1:
Input:
    1
  /   \ 
 3     2
Output:1 3 2

Example 2:
Input:
        10
     /      \
    20       30
  /   \
 40   60
Output:10 20 30 40 60 N N

Your Task:
You don't have to take any input. Complete the function levelOrder() that takes the root node as input parameter and returns a list of integers containing the level order traversal of the given Binary Tree.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ Number of nodes ≤ 10^5
1 ≤ Data of a node ≤ 10^5

*/



class Solution
{
    static ArrayList <Integer> levelOrder(Node node) 
    {
        // Your code here
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0) {
                Node n = q.poll();
                ans.add(n.data);
                if(n.left != null) {
                    q.add(n.left);
                }
                if(n.right != null) {
                    q.add(n.right);
                }
                size--;
            }
        }
        
        return ans;
    }
}
