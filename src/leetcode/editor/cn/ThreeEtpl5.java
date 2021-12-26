//给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。 
//
// 
// 
// 每条从根节点到叶节点的路径都代表一个数字： 
//
// 
// 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。 
// 
//
// 计算从根节点到叶节点生成的 所有数字之和 。 
//
// 叶节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：25
//解释：
//从根到叶子节点路径 1->2 代表数字 12
//从根到叶子节点路径 1->3 代表数字 13
//因此，数字总和 = 12 + 13 = 25 
//
// 示例 2： 
//
// 
//输入：root = [4,9,0,5,1]
//输出：1026
//解释：
//从根到叶子节点路径 4->9->5 代表数字 495
//从根到叶子节点路径 4->9->1 代表数字 491
//从根到叶子节点路径 4->0 代表数字 40
//因此，数字总和 = 495 + 491 + 40 = 1026
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 1000] 内 
// 0 <= Node.val <= 9 
// 树的深度不超过 10 
// 
// 
// 
//
// 
//
// 注意：本题与主站 129 题相同： https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/ 
//
// Related Topics 树 深度优先搜索 二叉树 👍 12 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.List;

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
    public int sumNumbers(TreeNode root) {

        // 更简洁的递归
        return dfs(root, 0);

//        return dfs(root, new LinkedList<>(), 0);
    }

    private int dfs(TreeNode root, int path){
        if (root == null){
            return 0;
        }
        path = path * 10 + root.val;
        if (root.left == null && root.right == null){
            return path;
        }
        return dfs(root.left, path) + dfs(root.right, path);

    }



//    // 绞尽脑汁自力更生版本
//    private int dfs(TreeNode root, List<Integer> nums, int sum){
//        if (root == null){
//            return sum;
//        }
//        else{
//            nums.add(root.val);
//            sum = dfs(root.left, nums, sum);
//            sum = dfs(root.right, nums, sum);
//        }
//
//        if (root.left != null || root.right != null){
//            nums.remove(nums.size()-1);
//        }
//        else{
//            int num = toNum(nums);
//            nums.remove(nums.size()-1);
//            sum += num;
//        }
//        return sum;
//    }
//
//    private int toNum(List<Integer> nums){
//        String tmp = "";
//        for (Integer num : nums){
//            tmp += String.valueOf(num.intValue());
//        }
//        return Integer.parseInt(tmp);
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
