//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 注意：本题与主站 199 题相同：https://leetcode-cn.com/problems/binary-tree-right-side-
//view/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 14 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        if (root == null){
            return new LinkedList<>();
        }

        List<Integer> result = new LinkedList<>();

        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        int current = 1;
        int next = 0;
        queue.offer(root);
        int right = 0;
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            current--;
            right = tmp.val;

            if (tmp.left != null){
                queue.offer(tmp.left);
                next++;
            }
            if (tmp.right != null){
                queue.offer(tmp.right);
                next++;
            }
            if (current == 0){
                result.add(right);
                current = next;
                next = 0;
            }
        }
        return result;



    }
}
//leetcode submit region end(Prohibit modification and deletion)
