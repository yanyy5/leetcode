//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-
//traversal/ 
// Related Topics 树 广度优先搜索 二叉树 👍 170 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 1;
        int next = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            tmp.add(node.val);
            count--;
            if (node.left != null){
                queue.offer(node.left);
                next++;
            }
            if (node.right != null){
                queue.offer(node.right);
                next++;
            }
            if (count == 0){
                result.add(new LinkedList<>(tmp));
                tmp.clear();
                count = next;
                next = 0;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
