class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // Save the length of the mountain array
        int length = mountainArr.length();

        // Initialize the cache
        Map<Integer, Integer> cache = new HashMap<>();

        // 1. Find the index of the peak element
        int low = 1;
        int high = length - 2;
        while (low != high) {
            int testIndex = (low + high) >> 1;

            int curr;
            if (cache.containsKey(testIndex)) {
                curr = cache.get(testIndex);
            } else {
                curr = mountainArr.get(testIndex);
                cache.put(testIndex, curr);
            }

            int next;
            if (cache.containsKey(testIndex + 1)) {
                next = cache.get(testIndex + 1);
            } else {
                next = mountainArr.get(testIndex + 1);
                cache.put(testIndex + 1, next);
            }

            if (curr < next) {
                if (curr == target) {
                    return testIndex;
                }
                if (next == target) {
                    return testIndex + 1;
                }
                low = testIndex + 1;
            } else {
                high = testIndex;
            }
        }

        int peakIndex = low;

        // 2. Search in the strictly increasing part of the array
        // If found, will be returned in the loop itself.
        low = 0;
        high = peakIndex;
        while (low <= high) {
            int testIndex = (low + high) >> 1;

            int curr;
            if (cache.containsKey(testIndex)) {
                curr = cache.get(testIndex);
            } else {
                curr = mountainArr.get(testIndex);
            }
                
            if (curr == target) {
                return testIndex;
            } else if (curr < target) {
                low = testIndex + 1;
            } else {
                high = testIndex - 1;
            }
        }

        // 3. Search in the strictly decreasing part of the array
        // If found, will be returned in the loop itself.
        low = peakIndex + 1;
        high = length - 1;
        while (low <= high) {
            int testIndex = (low + high) >> 1;

            int curr;
            if (cache.containsKey(testIndex)) {
                curr = cache.get(testIndex);
            } else {
                curr = mountainArr.get(testIndex);
            }
                
            if (curr == target) {
                return testIndex;
            } else if (curr > target) {
                low = testIndex + 1;
            } else {
                high = testIndex - 1;
            }
        }

        // Target is not present in the mountain array
        return -1;        
    }
}