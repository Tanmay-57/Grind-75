class Solution
{    // using BFS*********
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] indegree = new int[V];
        
        // Calculate in-degrees of all vertices
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        // Enqueue all vertices with in-degree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int[] res = new int[V];
        int index = 0;
        
        // Process vertices in topological order
        while (!q.isEmpty()) {
            int node = q.poll();
            res[index++] = node;
            
            // Decrease in-degree of all adjacent vertices
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                
                // If in-degree becomes 0, add to queue
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        
        return res;
    }
}
