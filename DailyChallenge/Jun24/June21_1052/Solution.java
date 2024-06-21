
// Sliding Window Approach
// Time: O(n), Space: O(1)

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // currWin - total number of unhappy customers in the current window of size 'minutes'
        // maxWin - maximum number of unhappy customers across all windows
        int currWin = 0, maxWin = 0;
        // nonGrumpySum - count of all happy customers
        int nonGrumpySum = 0, n = customers.length;
        for(int i=0; i<n; i++) {
            // if the customer is unhappy add it to the current window
            currWin += grumpy[i]*customers[i];
            // if the customer is happy add it to the nonGrumpySum
            nonGrumpySum += (1 - grumpy[i])*customers[i];
            // If the window size exceeds 'minutes', remove unhappy customers from the start of the window
            if(i >= minutes)
                currWin -= grumpy[i-minutes]*customers[i-minutes];
            maxWin = Math.max(maxWin, currWin);
        }
        return maxWin+nonGrumpySum;
    }
}