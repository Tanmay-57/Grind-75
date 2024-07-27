/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, list);
        return String.join(",", list); 
        //joins the elements of a list into a single string, with each element separated by a comma.
    }

    private void helper(TreeNode node, List<String> list ){
        if(node== null){
            list.add("null");
            return;
        }

        list.add(String.valueOf(node.val));
        helper(node.left, list);
        helper(node.right, list);
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper2(list);
    }

    private TreeNode helper2(List<String> list){
        String val = list.remove(0);

        if(val.equals("null")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper2(list);
        node.right = helper2(list);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


Meth 2

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root== null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node== null){
                res.append("n ");
                continue;
            }
            res.append(node.val+" ");
            q.add(node.left);
            q.add(node.right);
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
