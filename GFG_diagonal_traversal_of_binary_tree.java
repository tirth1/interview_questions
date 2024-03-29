/*

Given a Binary Tree, print the diagonal traversal of the binary tree.

Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.

Example 1:
  Input :
              8
           /     \
          3      10
        /   \      \
       1     6     14
           /   \   /
          4     7 13
  Output : 8 10 14 3 6 7 13 1 4
  Explanation: Diagonal Traversal of binary tree : 8 10 14 3 6 7 13 1 4
 
Your Task:
You don't need to read input or print anything. The task is to complete the function diagonal() that takes the root node as input argumets and returns the diagonal traversal of the given tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
Here N is number of nodes.

Constraints:
1 <= Number of nodes<= 10^5
1 <= Data of a node<= 10^5

*/


class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           ArrayList<Integer> ans = new ArrayList<>();
           Queue<Node> q = new LinkedList<>();
           q.add(root);
           
           while(!q.isEmpty()) {
               int size = q.size();
               while(size-- > 0) {
                   Node node = q.poll();
                   while(node != null) {
                        ans.add(node.data);
                        if(node.left != null) {
                            q.add(node.left);
                        }
                        node = node.right;
                   }
               }
           }
           
           return ans;
      }
}
