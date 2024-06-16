
// Brute Force Approach
// Time Complexity: O(N*N)
// Check the Solution of LeetCode 3185 for O(N) approach

class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int n = hours.length;
        int res = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++) {
                if((hours[i]+hours[j])%24 == 0)
                    res++;
            }
        }
        return res;
    }
}