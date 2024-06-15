
// Brute Force: Using 2 Nested loops
// Time Complexity: O(N*K) - will result in TLE

class Approach1 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        boolean[] selected = new boolean[n];
        while(k-- > 0) {
            int maxProfitIdx = -1;
            // choose the affordable project with maximum profit
            for(int j=0; j<n; j++) {
                if(capital[j] <= w && !selected[j]) {
                    if(maxProfitIdx == -1 || profits[j] > profits[maxProfitIdx])
                        maxProfitIdx = j;
                }
            }
            // no project is affordable with current budget
            if(maxProfitIdx == -1)
                break;
            // update the budget
            w += profits[maxProfitIdx];
            selected[maxProfitIdx] = true;
        }
        return w;
    }
}