class Pair{
    int   hd;
    Node node;
    Pair(Node node,int hd){
        this.node=node;
        this.hd=hd;
    }
}

class Solution {
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.hd;
            Node temp = it.node;

            // ****Only put in the map if it is the first node at this 
            //horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, temp.data);
            }

            // Traverse the left child
            if (temp.left != null) {
                q.add(new Pair(temp.left, hd - 1));
            }
            // Traverse the right child
            if (temp.right != null) {
                q.add(new Pair(temp.right, hd + 1));
            }
        }

        // Add the values from the map to the answer list in sorted order of keys
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}
