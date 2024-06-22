// HashMap based approach
// Time Complexity: O(n)
// Space Complexity: O(n)

class Approach3 {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int oddCount = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        for(int num: nums) {
            oddCount += num%2;
            if(countMap.containsKey(oddCount-k))
                result += countMap.get(oddCount-k);
            countMap.put(oddCount, countMap.getOrDefault(oddCount, 0)+1);
        }
        return result;
    }
}