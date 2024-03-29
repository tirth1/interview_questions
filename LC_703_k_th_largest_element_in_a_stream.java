/*

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Returns the element representing the kth largest element in the stream.
 

Example 1:
  Input
    ["KthLargest", "add", "add", "add", "add", "add"]
    [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
  Output
    [null, 4, 5, 5, 8, 8]
  Explanation
    KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
    kthLargest.add(3);   // return 4
    kthLargest.add(5);   // return 5
    kthLargest.add(10);  // return 5
    kthLargest.add(9);   // return 8
    kthLargest.add(4);   // return 8
 

Constraints:
  1 <= k <= 10^4
  0 <= nums.length <= 10^4
  -10^4 <= nums[i] <= 10^4
  -10^4 <= val <= 10^4
  At most 104 calls will be made to add.
  It is guaranteed that there will be at least k elements in the array when you search for the kth element.

*/

class KthLargest {

    PriorityQueue<Integer> queue;
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k)
            queue.poll();
        return queue.peek();
    }
}




class KthLargest {
    
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        //Use min heap to store the k-th largest element on top
        this.pq = new PriorityQueue<>(k);
        for(int x : nums) {
            this.add(x);
        }
    }
    
    public int add(int val) {
        if(pq.size() == this.k) {
            if(val > pq.peek()) {
                pq.poll();
                pq.add(val);
            }
        } else {
            pq.add(val);
        }
        return pq.peek();
    }
}
