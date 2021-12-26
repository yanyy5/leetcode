//给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。 
//
// 
//
// 示例 1： 
//
// 
//输入: root = [8,6,10,5,7,9,11], k = 12
//输出: true
//解释: 节点 5 和节点 7 之和等于 12
// 
//
// 示例 2： 
//
// 
//输入: root = [8,6,10,5,7,9,11], k = 22
//输出: false
//解释: 不存在两个节点值之和为 22 的节点
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// root 为二叉搜索树 
// -10⁵ <= k <= 10⁵ 
// 
//
// 
//
// 注意：本题与主站 653 题相同： https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 8 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

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
    public boolean findTarget(TreeNode root, int k) {


        // hashset
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashSet<Integer> set = new HashSet<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (set.contains(k-cur.val)){
                return true;
            }
            set.add(cur.val);
            cur = cur.right;
        }
        return false;



//        // 直接在二叉搜索树中找
//        // 遍历第一次，保存BST的节点
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        List<TreeNode> nodes = new LinkedList<>();
//        TreeNode cur = root;
//        while (cur != null || !stack.isEmpty()){
//            while (cur != null){
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            nodes.add(cur);
//            cur = cur.right;
//        }
//
//        for (int i = 0; i < nodes.size(); i++){
//            cur = nodes.get(i);
//            int find = k-cur.val;
//            if (find != cur.val){
//                boolean isFound = findAnother(root, find);
//                if (isFound){
//                    return true;
//                }
//            }
//        }
//        return false;


    }

//    // 直接找另一个，时间复杂度O(h)
//    private boolean findAnother(TreeNode root, int k){
//        TreeNode cur = root;
//        while (cur != null){
//            if (cur.val == k){
//                return true;
//            }
//            else if (cur.val > k){
//                cur = cur.left;
//            }
//            else {
//                cur = cur.right;
//            }
//        }
//        return false;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
