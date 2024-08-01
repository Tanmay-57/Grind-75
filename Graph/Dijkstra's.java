class Pair{
    int node;
    int dis;
    
    public Pair(int d, int n){
        this.node= n;
        this.dis= d;
    }
}


class Solution {
    // Function to find the shortest distance of all the vertices from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Priority queue to select the node with the smallest distance
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.dis - y.dis);

        // Array to store the shortest distance from source to each vertex
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize with infinity

        dist[S] = 0; // Distance to source is 0
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            int distance = pq.peek().dis;
            int node = pq.peek().node;
            pq.poll();

            // Iterate over all adjacent nodes
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1); // Edge weight
                int adjNode = adj.get(node).get(i).get(0);    // Adjacent node

                // If a shorter path is found
                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }
}
