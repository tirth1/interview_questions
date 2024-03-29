/*

Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal.
For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5 10 4 14 25.
 
Example 1:
  Input:
         1
       /   \
      3     2
  Output: 3 1 2
  Explanation:
    First case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2.
    Thus nodes of the binary tree will be printed as such 3 1 2.

Example 2:
  Input:
           10
         /    \
        20    30
       /  \
      40   60
  Output: 40 20 60 30

Your Task:
  This is a functional problem, you don't need to care about input, just complete the function bottomView() which takes the root node of the tree as input and returns an array containing the bottom view of the given tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
  1 <= Number of nodes <= 10^5
  1 <= Data of a node <= 10^5

Note: 
  The Input/Output format and Example given are used for the system's internal purpose, and should be used by a user for Expected Output only.
  As it is a function problem, hence a user should not read any input from the stdin/console. The task is to complete the function specified, and not to write the full code.

*/


class Solution
{
    
    public void width(Node root, int hl, int[] minMax) {
        if(root == null) {
            return;
        }
        
        minMax[0] = Math.min(minMax[0], hl);
        minMax[1] = Math.max(minMax[1], hl);
        
        width(root.left, hl-1, minMax);
        width(root.right, hl+1, minMax);
    }
    
    class vPair {
        Node node;
        int hl;
        
        vPair(Node node, int hl) {
            this.node = node;
            this.hl = hl;
        }
    }
    
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        int[] minMax = new int[2];
        
        width(root, 0, minMax);
        int len = minMax[1] + Math.abs(minMax[0]) + 1;
        for(int i=0; i<len; i++) {
            ans.add(0);
        }
        
        LinkedList<vPair> q = new LinkedList<>();
        q.add(new vPair(root, Math.abs(minMax[0])));
        
        while(q.size() != 0){
            int size = q.size();
            while(size-- > 0) {
                vPair rp = q.removeFirst();
                Node node = rp.node;
                int hl = rp.hl;
                System.out.println(hl);
                ans.set(hl, node.data);
                if(node.left != null) {
                    q.addLast(new vPair(node.left, hl-1));
                }
                if(node.right != null) {
                    q.addLast(new vPair(node.right, hl+1));
                }
            }
        }
        
        return ans;
    }
}
