// Time Complexity: O(nlogn)

class Approach1 {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4)
            return 0;
        Arrays.sort(nums);
        int res = nums[n-1]-nums[0];
        // min(nums[n-1]-nums[3], nums[n-2]-nums[2], nums[n-3]-nums[1], nums[n-4]-nums[0])
        for(int i=0; i<=3; i++)
            res = Math.min(res, nums[n-1-(3-i)]-nums[i]);
        return res;
    }
}