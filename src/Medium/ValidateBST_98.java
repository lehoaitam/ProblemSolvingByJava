package Medium;

import library.TreeNode;

/**
 * Created by lehoaitam on 1/6/17.
 */
public class ValidateBST_98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(15);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(20);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        System.out.println(isValidBST(root));
    }

    public static  boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if( (root.left != null && root.left.val >= root.val) ||
                (root.right != null && root.right.val <= root.val))
            return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
