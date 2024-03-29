class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[] prev = new int[target+1];
        int mod = 1000000007;
        prev[0] = 1;
        for(int i=1; i<=n; i++) {
            int[] next = new int[target+1];

            for(int j=1; j<=k; j++) {
                for(int t=j; t<=target; t++) {
                    next[t] = (next[t] + prev[t-j])%mod;
                    
                }
            }

            prev = next; 
        }

        return prev[target]%mod;
    }
}