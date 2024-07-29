class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    ArrayList<Integer> res = new ArrayList<>();
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        dfs(adj, 0, visited);
        return res;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] vis ){
        res.add(curr);
        vis[curr]= true;
        
        for(int i=0;i< adj.get(curr).size();i++){
            int des= adj.get(curr).get(i);
            
            if(vis[des]==false){
                dfs(adj, des, vis);
            }
        }
    }
}
