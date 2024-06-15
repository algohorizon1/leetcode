import java.util.PriorityQueue;

// minHeap (PriorityQueue) + maxHeap (PriorityQueue)

class Approach3 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        // stores the indexes of projects
        // project with minimum capital requirement will be at the top
        PriorityQueue<Integer> capitalMinHeap = new PriorityQueue<>((i, j)->{
            return capital[i]-capital[j];
        });

        // stores the indexes of projects
        // project with maximum profit will be at the top
        PriorityQueue<Integer> profitsMaxHeap = new PriorityQueue<>((i, j)->{
            return profits[j]-profits[i];
        });

        for(int i=0; i<n; i++) {
            if(capital[i] <= w) {
                profitsMaxHeap.offer(i);
            } else {
                capitalMinHeap.offer(i);
            }
        }

        while(k-- > 0) {
            if(profitsMaxHeap.isEmpty())
                break;
            w += profits[profitsMaxHeap.poll()];
            while(!capitalMinHeap.isEmpty() && capital[capitalMinHeap.peek()] <= w)
                profitsMaxHeap.offer(capitalMinHeap.poll());
        }
        return w;
    }
}