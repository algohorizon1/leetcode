
// Binary Search Approach
class Solution {
    // checks whether we can place m balls with minimum distance between adjacent balls >= gap
    private boolean isGapFeasible(int[] pos, int m, int gap) {
        int countBalls = 1, prevBallIdx = 0;
        for(int i=1; i<pos.length; i++) {
            if(pos[i]-pos[prevBallIdx] >= gap) {
                countBalls++;
                if(countBalls == m)
                    return true;
                prevBallIdx = i;
            }
        }
        return false;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int l = 1, h = (position[n-1]-position[0])/(m-1);
        int res = 1;
        while(l <= h) {
            int gap = l + (h-l)/2;
            if(isGapFeasible(position, m, gap)) {
                res = gap;
                l = gap+1;
            } else {
                h = gap-1;
            }
        }
        return res;
    }
}