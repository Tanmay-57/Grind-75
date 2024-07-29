
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
         ArrayList<Integer> res = new ArrayList<>();
        
        boolean[] visited = new boolean[V]; // Correct size to V
        Queue<Integer> q = new LinkedList<>();
        q.offer(0); // source 0

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (!visited[curr]) {
                res.add(curr);
                visited[curr] = true;

                for (int i = 0; i < adj.get(curr).size(); i++) {
                    q.offer(adj.get(curr).get(i));
                }
            }
        }
        
        return res;
    }
}
