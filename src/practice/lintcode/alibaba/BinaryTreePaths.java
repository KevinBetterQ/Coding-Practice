package practice.lintcode.alibaba;

import java.util.ArrayList;
import java.util.List;

/**  
* Description:给一棵二叉树，找出从根节点到叶子节点的所有路径。
* @author qwk 
* idea: 二叉树遍历
*/


 
 

public class BinaryTreePaths {
	
	public class TreeNode {
	      public int val;
	      public TreeNode left, right;
	      public TreeNode(int val) {
	         this.val = val;
	          this.left = this.right = null;
	      }
	  }
	
	//solution——qwk
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>(); 
        if(root == null) return list;
        String path = "" + root.val;
        if(root.left == null && root.right == null) {
            list.add(path);
        }
        if(root.left != null) dfs(root.left, list, path);
        if(root.right != null) dfs(root.right, list, path);
        return list;
        
    }
    
    public static void dfs(TreeNode root, List<String> list, String path) {
        path = path + "->" + root.val;
        if(root.left == null && root.right == null) {
            list.add(path);
        }
        
        if(root.left != null) dfs(root.left, list, path);
        if(root.right != null) dfs(root.right, list, path);
    }
    
    /*
     * Solution-answer
     */
    public List<String> binaryTreePaths_best(TreeNode root) {
    	List<String> paths = new ArrayList<>();
    	if(root == null) return paths;
    	
    	List<String> leftPaths = new ArrayList<>();
    	List<String> rightPaths = new ArrayList<>();
    	leftPaths = binaryTreePaths_best(root.left);
    	rightPaths = binaryTreePaths_best(root.right);
    	for(String path : leftPaths) {
    		paths.add(root.val + "->" + path);
    	}
    	for(String path : rightPaths) {
    		paths.add(root.val + "->" + path);
    	}
    	if (paths.size() == 0) {
    		paths.add("" + root.val);
    	}
    	
    	return paths;
    }

}














