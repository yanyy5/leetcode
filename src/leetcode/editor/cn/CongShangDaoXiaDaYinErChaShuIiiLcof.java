//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
//  [20,9],
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
// Related Topics 树 广度优先搜索 二叉树 👍 171 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Collection;
import java.util.Collections;
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
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
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
                if (result.size() % 2 != 0){
                    Collections.reverse(tmp);
                }
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
