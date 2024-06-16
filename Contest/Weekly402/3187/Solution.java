class Solution {
    // declaring a segment tree
    int[] st;

    // ss - segment start, se - segment index, si - segment index
    private int constructST(int[] nums, int ss, int se, int si) {
        if(ss == se) {
            st[si] = 0;
            return 0;
        }
        int m = ss + (se - ss)/2;
        st[si] += constructST(nums, ss, m, 2*si+1);
        st[si] += constructST(nums, m+1, se, 2*si+2);
        // if the subarray size is greater than 2
        if(ss < se - 1) {
            // check if the element at index m is a peak element, similarly check the element at index m+1
            if(nums[m] > nums[m+1]) {
                if(nums[m] > nums[m-1])
                    st[si]++;
            } else if(nums[m] < nums[m+1]) {
                if(m+1 < se && nums[m+1] > nums[m+2])
                    st[si]++;
            }
        }
        return st[si];
    }

    // ss - segment start, se - segment index, si - segment index
    // idx - index to update in nums array
    // val - new value to assign
    private int updateST(int[] nums, int ss, int se, int si, int idx, int val) {
        // if the current subarray doesn't contain index idx then return the current subarray value
        if(idx < ss || idx > se)
            return st[si];
        if(ss == se) {
            nums[idx] = val;
            st[si] = 0;
            return 0;
        }
        int m = ss + (se - ss)/2;
        int res = 0;
        res += updateST(nums, ss, m, 2*si+1, idx, val);
        res += updateST(nums, m+1, se, 2*si+2, idx, val);
        // if the subarray size is greater than 2
        if(ss < se - 1) {
            // check if the element at index m is a peak element, similarly check the element at index m+1
            if(nums[m] > nums[m+1]) {
                if(nums[m] > nums[m-1])
                    res++;
            } else if(nums[m] < nums[m+1]) {
                if(m+1 < se && nums[m+1] > nums[m+2])
                    res++;
            }
        }
        return st[si]=res;
    }

    // ss - segment start, se - segment index, si - segment index
    // qs - query start, qe - query end
    private int searchST(int[] nums, int ss, int se, int si, int qs, int qe) {
        // if the current subarray doesn't interset with query subarray return 0
        if(ss > qe || se < qs)
            return 0;
        // if current subarray is subset of query subarray then return the current subarray value
        if(ss >= qs && se <= qe)
            return st[si];
        int m = ss + (se - ss)/2;
        int res = 0;
        res += searchST(nums, ss, m, 2*si+1, qs, qe);
        res += searchST(nums, m+1, se, 2*si+2, qs, qe);
        if(ss < se - 1) {
            // check if the element at index m is a peak element, similarly check the element at index m+1
            // here extra check is index should also lie within the query subarray
            if(nums[m] > nums[m+1]) {
                if(nums[m] > nums[m-1] && m > qs && m < qe)
                    res++;
            } else if(nums[m] < nums[m+1]) {
                if(m+1 < se && nums[m+1] > nums[m+2] && m+1 > qs && m+1 < qe)
                    res++;
            }
        }
        return res;
    }

    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        // max length of segment tree is upper bounded by 4*n
        st = new int[4*n];
        // construct segment tree
        constructST(nums, 0, n-1, 0);
        List<Integer> res = new ArrayList<>();
        for(int[] q: queries) {
            if(q[0] == 1)
                res.add(searchST(nums, 0, n-1, 0, q[1], q[2]));
            else
                updateST(nums, 0, n-1, 0, q[1], q[2]);
        }
        return res;
    }
}