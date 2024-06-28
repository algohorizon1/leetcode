// Counting Sort based approach

// Time Complexity: O(n + edges)
// Space Complexity: O(n)

class Approach2 {
    public long maximumImportance(int n, int[][] roads) {
        // Counting Sort based approach

        // Initialize an array to store the degree of each node
        int[] deg = new int[n];
        // For each road, increment the degree of both connected nodes
        for(int[] r: roads) {
            deg[r[0]]++;
            deg[r[1]]++;
        }

        // Initialize an array to store the frequency of each degree
        int[] freq = new int[n];
        // Count the frequency of each degree
        for(int d: deg)
            freq[d]++;

        // Initialize the result variable and a value variable to assign importance values
        long res = 0;
        long val = 1;

        // Iterate over the degree frequencies
        for(int i=0; i<n; i++)
            // For each frequency, assign values in ascending order
            for(int j=freq[i]; j>0; j--)
                res += i*val++;

        return res;
    }
}