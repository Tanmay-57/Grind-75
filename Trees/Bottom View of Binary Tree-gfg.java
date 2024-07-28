class Pair{
    int hd;
    Node node;
    
    Pair(Node node, int hd){
        this.node= node;
        this.hd = hd;
    }
}

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer>ans  = new ArrayList<>(); // storing the ans 
        if(root ==null){
            return ans; // emplty arraylist 
        }
        
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair it= q.poll();
            int hd =it.hd;
            Node temp = it.node;
            
            // Update the map with the current node's value for the horizontal distance
            //*****the map update whenever new value of hd(ke) is found
            map.put(hd, temp.data);
            
            if(temp.left!=null){
                q.add(new Pair(temp.left,hd-1));
            }
            if(temp.right!=null){
                q.add(new Pair(temp.right,hd+1));
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        
        return ans;
    }
}
