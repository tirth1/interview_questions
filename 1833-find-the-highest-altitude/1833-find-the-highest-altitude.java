class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int prev = 0;
        
        for(int g: gain) 
            ans = Math.max(ans, prev = g+prev);
        
        return ans;
    }
}