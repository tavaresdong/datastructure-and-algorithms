package tree.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class BinaryTreeInorderTraversal {

    private void traverse(TreeNode root, List<Integer> curResult) {
        if (root == null) {
            return;
        }

        traverse(root.left, curResult);
        curResult.add(root.val);
        traverse(root.right, curResult);
    }

    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    public static void main(String[] args) {

        TreeNode n = new TreeNode(1);
        n.right = new TreeNode(2);
        n.right.left = new TreeNode(3);

        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
        List<Integer> result = btit.inorderTraversal(n);
        System.out.println(result);
    }
}