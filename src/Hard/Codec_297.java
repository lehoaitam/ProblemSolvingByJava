package Hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import library.TreeNode;

/**
 * Created by lehoaitam on 10/22/16.
 */
public class Codec_297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<TreeNode> queue = new LinkedList<TreeNode>();
        StringBuilder result = new StringBuilder();
        result.append("[");
        queue.add(root);
        while(!queue.isEmpty()){
            //add current node value
            TreeNode node = queue.remove(0);
            String str;
            if(node == null) str = "null,";
            else {
                str = String.valueOf(node.val) + ",";
                queue.add(node.left);
                queue.add(node.right);
            }
            result.append(str);
        }
        //remove last comma
        if(result.lastIndexOf(",") == result.length()-1) result.deleteCharAt(result.length()-1);
        result.append("]");
        return result.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringBuilder strBuilder = new StringBuilder(data);
        //delete [,] characters
        strBuilder.deleteCharAt(0);
        strBuilder.deleteCharAt(strBuilder.length()-1);
        //split into array of TreeNode value
        String[] arrStr = strBuilder.toString().split(",");
        if(arrStr.length == 0 || arrStr[0].equals("")) return null;

        List<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(arrStr[0]));
        queue.add(root);
        //trarvse in list of arrStr
        int i = 1;
        while(!queue.isEmpty()){
            //add leftnode node
            TreeNode node = queue.remove(0);
            if(i < arrStr.length){
                if(!("null".equals(arrStr[i]))){
                    TreeNode leftNode = new TreeNode(Integer.parseInt(arrStr[i]));
                    node.left = leftNode;
                    queue.add(leftNode);
                }
                i++;
            }else break;
            //add rightnode to node
            if(i < arrStr.length){
                if(!("null".equals(arrStr[i]))){
                    TreeNode rightNode = new TreeNode(Integer.parseInt(arrStr[i]));
                    node.right = rightNode;
                    queue.add(rightNode);
                }
                i++;
            }else break;

        }
        return root;
    }
}
