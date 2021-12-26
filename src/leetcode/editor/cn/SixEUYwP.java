//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// 
//
// 注意：本题与主站 437 题相同：https://leetcode-cn.com/problems/path-sum-iii/ 
// Related Topics 树 深度优先搜索 二叉树 👍 12 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

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
    public int pathSum(TreeNode root, int targetSum) {

        // 方法2：前缀和
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0,1);
        return dfs(root, targetSum, 0, prefix);

//        int result = dfs(root, targetSum, 0);
//        int x = 0,y=0;
//        if (root != null){
//            x = pathSum(root.left, targetSum);
//            y = pathSum(root.right, targetSum);
//        }
//        return result+x+y;
    }

    private int dfs(TreeNode root, int targetSum, int sum, Map<Integer, Integer> prefix){
        if (root == null){
            return 0;
        }

        int res = 0;
        sum += root.val;
        res = prefix.getOrDefault(sum-targetSum, 0);
        prefix.put(sum, prefix.getOrDefault(sum, 0)+1);

        res += dfs(root.left, targetSum, sum, prefix);
        res += dfs(root.right, targetSum, sum, prefix);

        // 比累加数组多一步处理,相当于不再考虑当前节点
        prefix.put(sum, prefix.getOrDefault(sum, 0)-1);

        return res;

    }


//    // 一个啰嗦的递归
//    private int dfs(TreeNode root, int targetSum, int result){
//        if (root == null){
//            return 0;
//        }
//        if (root.val == targetSum){
//            result++;
//        }
//        int left = dfs(root.left, targetSum-root.val, 0);
//        int right = dfs(root.right, targetSum-root.val, 0);
//        int sum = left+right+result;
//        return sum;
//
//    }



}
//leetcode submit region end(Prohibit modification and deletion)
