
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int minimumOperations(int[] nums) {
        // remainder 0 - already divisible by 3, no operation needed
        // remainder 1 - decrease by 1 to make it divisible by 3
        // remainder 2 - increase by 1 to make it divisible by 3

        int res = 0;
        for(int num: nums) {
            if(num%3 != 0)
                res++;
        }
        return res;
    }
}