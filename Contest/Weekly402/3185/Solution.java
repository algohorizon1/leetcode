
// Time Complexity : O(N)
// Space Complexity: O(1)

class Solution {
    public long countCompleteDayPairs(int[] hours) {
        int[] freq = new int[24];
        int n = hours.length;
        long res = 0;
        for(int hour: hours) {
            int rem = hour%24;
            res += rem == 0 ? freq[0] : freq[24-rem];
            freq[rem]++;
        }
        return res;
    }
}