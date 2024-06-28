// Using library Sort function

// Time Complexity: O(nlogn + edges)
// Space Complexity: O(n)

class Approach1 {
    public long maximumImportance(int n, int[][] roads) {
         // Using library Sort function

         // Initialize an array to store the degree of each node
         int[] deg = new int[n];
         // For each road, increment the degree of both connected nodes
         for(int[] r: roads) {
             deg[r[0]]++;
             deg[r[1]]++;
         }
         // Sort the degree array
         Arrays.sort(deg);
         // Initialize the result variable
         long res = 0;
         // Assign values based on the sorted degree array in descending order
         for(int i=n-1; i>=0; i--)
             res += 1l*deg[i]*(i+1);

         return res;
    }
}