//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 645 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++){
            indexMap.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, n-1, 0, n-1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int pl, int pr, int il, int ir){
        if (pl > pr){
            return null;
        }

        int preRoot = pl;
        int inRoot = indexMap.get(preorder[preRoot]);

        TreeNode root = new TreeNode(preorder[preRoot]);
        int leftSize = inRoot - il;
        root.left = helper(preorder, inorder, pl+1, pl+leftSize, il, inRoot-1);
        root.right = helper(preorder, inorder, pl+leftSize+1, pr, inRoot+1, ir);
        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
