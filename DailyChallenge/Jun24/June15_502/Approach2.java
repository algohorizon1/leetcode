import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// Sorting + maxHeap (PriorityQueue)

class Approach2 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<int[]> temp = new ArrayList<>(n);
        for(int i=0; i<n; i++)
            temp.add(new int[]{capital[i], profits[i]});
        Collections.sort(temp, (a, b)-> {
            return a[0]-b[0];
        });

        int j = 0;
        PriorityQueue<Integer> profitsMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        while(k-- > 0) {
            while(j < n && temp.get(j)[0] <= w) {
                profitsMaxHeap.offer(temp.get(j)[1]);
                j++;
            }
            if(profitsMaxHeap.isEmpty())
                break;
            w += profitsMaxHeap.poll();
        }
        return w;
    }
}