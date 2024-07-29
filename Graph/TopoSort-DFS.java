class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfsTopo(adj, i, visited, st);
            }
        }
        
        int[] res = new int[V];
        int i=0;
        while(!st.isEmpty()) {
            res[i]= st.pop();
            i++;
        }
        
        return res;
    }
    
    public static void dfsTopo(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] vis ,Stack<Integer> st){
        vis[curr]= true;
        
        for(int i=0;i< adj.get(curr).size();i++){
            int des= adj.get(curr).get(i);
            
            if(vis[des]==false){
                dfsTopo(adj, des, vis,st);
            }
        }
        
        st.push(curr);  
    }
}
