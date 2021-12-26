//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
//解释:
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
//解释:
//          1
//         / \
//        2   3
// 
//
// 示例3： 
//
// 
//输入: root = [1]
//输出: [1]
// 
//
// 示例4： 
//
// 
//输入: root = [1,null,2]
//输出: [1,2]
//解释:      
//           1 
//            \
//             2     
// 
//
// 示例5： 
//
// 
//输入: root = []
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 515 题相同： https://leetcode-cn.com/problems/find-largest-value-in-
//each-tree-row/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 9 👎 0

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
    public List<Integer> largestValues(TreeNode root) {

        //方法2：只用一个queue
        if (root == null){
            return new LinkedList<>();
        }

        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int current = 1;
        int next = 0;
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()){

            TreeNode tmp = queue.poll();
            current--;
            // find the max in queue
            max = Math.max(max, tmp.val);

            if (tmp.left != null){
                queue.offer(tmp.left);
                next++;
            }
            if (tmp.right != null){
                queue.offer(tmp.right);
                next++;
            }
            if (current == 0){
                result.add(max);
                max = Integer.MIN_VALUE;
                current = next;
                next = 0;
            }
        }
        return result;




//        // 方法1：两个queue （绞尽脑汁版）
//        if (root == null){
//            return new LinkedList<>();
//        }
//
//        List<Integer> result = new LinkedList<>();
//        Queue<TreeNode> queue1 = new LinkedList<>();
//        Queue<TreeNode> queue2 = new LinkedList<>();
//        TreeNode tmp;
//
//        queue1.offer(root);
//        while (!queue1.isEmpty() || !queue2.isEmpty()){
//            // move queue 1 to queue 2
//            while (!queue1.isEmpty()){
//                tmp = queue1.poll();
//                queue2.offer(tmp);
//            }
//            // find max in queue 2 and add items to queue 1
//            int max = Integer.MIN_VALUE;
//            while (!queue2.isEmpty()){
//                tmp = queue2.poll();
//                max = Math.max(max, tmp.val);
//                if (tmp.left != null){
//                    queue1.offer(tmp.left);
//                }
//                if (tmp.right != null){
//                    queue1.offer(tmp.right);
//                }
//            }
//            result.add(max);
//        }
//        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
