// Dynamic Size Sliding Window Approach
// Time Complexity: O(n)
// Space Complexity: O(1)

class Approach5 {
    private int atMost(int[] nums, int maxOdds) {
        int res = 0;
        int currentOddCount = 0;
        int start = 0;

        for(int end = 0; end < nums.length; end++) {
            currentOddCount += nums[end]%2;
            while(currentOddCount > maxOdds) {
                currentOddCount -= nums[start]%2;
                start++;
            }
            res += (end-start+1);
        }
        return res;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }
}