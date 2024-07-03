// Time Complexity: O(n)
// Space Complexity: O(1)

class Approach2 {
    private void shiftRight(int[] arr, int i) {
        for(int j=arr.length-1; j>i; j--)
            arr[j] = arr[j-1];
    }

    private void shiftLeft(int[] arr, int i) {
        for(int j=0; j<i; j++)
            arr[j] = arr[j+1];
    }

    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4)
            return 0;

        int[] min4 = new int[4];
        int[] max4 = new int[4];

        Arrays.fill(min4, Integer.MAX_VALUE);
        Arrays.fill(max4, Integer.MIN_VALUE);

        // fill min4 array
        for(int num: nums) {
            for(int i=0; i<min4.length; i++) {
                if(num < min4[i]) {
                    shiftRight(min4, i);
                    min4[i] = num;
                    break;
                }
            }
        }
        // fill max4 array
        for(int num: nums) {
            for(int i=max4.length-1; i>=0; i--) {
                if(num > max4[i]) {
                    shiftLeft(max4, i);
                    max4[i] = num;
                    break;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i=0; i<min4.length; i++)
            res = Math.min(res, max4[i]-min4[i]);
        return res;
    }
}