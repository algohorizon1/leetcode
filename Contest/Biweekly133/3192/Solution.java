// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int minOperations(int[] nums) {
        int flipCount = 0;
        for(int i=0; i<nums.length; i++) {
            nums[i] = (nums[i] + flipCount)%2;
            if(nums[i] == 0) {
                nums[i] = 1;
                flipCount++;
            }
        }
        return flipCount;
    }
}