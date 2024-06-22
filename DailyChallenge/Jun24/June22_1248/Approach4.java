// using countArr of size n instead of HashMap
// Time Complexity: O(n)
// Space Complexity: O(n)

class Approach4 {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int oddCount = 0;
        int n = nums.length;
        int[] countArr = new int[n+1];
        countArr[0] = 1;
        for(int num: nums) {
            oddCount += num%2;
            if(oddCount-k >= 0)
                result += countArr[oddCount-k];
            countArr[oddCount]++;
        }
        return result;
    }
}