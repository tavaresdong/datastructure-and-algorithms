package tree.binary_tree;

import java.util.LinkedList;

public class DeserializeAndSerializeBinaryTree {

    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuffer sb = new StringBuffer();
        LinkedList<TreeNode> fifo = new LinkedList<>();
        fifo.addFirst(root);

        // @ as the start of the serialization
        sb.append("@");
        return doSerialize(fifo, sb);
    }

    private String doSerialize(LinkedList<TreeNode> queue, StringBuffer sb) {
        while (!queue.isEmpty()) {
            TreeNode elem = queue.removeFirst();
            sb.append(',');
            if (elem != null) {
                sb.append(elem.val);
                queue.addLast(elem.left);
                queue.addLast(elem.right);
            } else {
                sb.append('#');
            }
        }

        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        String[] tokens = data.split(",");
        if (tokens.length < 4) {
            // Error
            return null;
        }

        int startIndex = 1;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(tokens[1]));
        nodes.addLast(root);

        doDeserialize(nodes, tokens, startIndex);
        return root;
    }

    private void doDeserialize(LinkedList<TreeNode> nodes, String[] tokens, int idx) {
        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.removeFirst();
            String lvalue = tokens[idx + 1];
            String rvalue = tokens[idx + 2];
            idx += 2;
            if (!lvalue.equals("#")) {
                int value = Integer.parseInt(lvalue);
                cur.left = new TreeNode(value);
                nodes.addLast(cur.left);
            }

            if (!rvalue.equals("#")) {
                int value = Integer.parseInt(rvalue);
                cur.right = new TreeNode(value);
                nodes.addLast(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        String serializedTree = new DeserializeAndSerializeBinaryTree().serialize(root);
        System.out.println(serializedTree);

        TreeNode reconstructedTree = new DeserializeAndSerializeBinaryTree().deserialize(serializedTree);
        System.out.println(new DeserializeAndSerializeBinaryTree().serialize(reconstructedTree));
    }
}
