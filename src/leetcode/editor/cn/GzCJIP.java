//数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。 
//
// 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。 
//
// 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。 
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [10, 15, 20]
//输出：15
//解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
// 
//
// 示例 2： 
//
// 
//输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//输出：6
//解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= cost.length <= 1000 
// 0 <= cost[i] <= 999 
// 
//
// 
//
// 注意：本题与主站 746 题相同： https://leetcode-cn.com/problems/min-cost-climbing-stairs/ 
//
// Related Topics 数组 动态规划 👍 17 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {


        // 只保存最近2位
        int[] dp = new int[]{cost[0], cost[1]};
        for (int i = 2; i < cost.length; i++){
            dp[i % 2] = Math.min(dp[0], dp[1])+cost[i];
        }
        return Math.min(dp[0], dp[1]);

//        // 保存前面的迭代
//        int len = cost.length;
//        int[] dp = new int[len];
//        dp[0] = cost[0];
//        dp[1] = cost[1];
//        for (int i = 2; i < len; i++){
//            dp[i] = Math.min(dp[i-1], dp[i-2])+cost[i];
//        }
//        return Math.min(dp[len-1], dp[len-2]);

//        // 保存前面的递归
//        int len = cost.length;
//        int[] dp = new int[len];
//        helper(cost, len-1, dp);
//        return Math.min(dp[len-1], dp[len-2]);


//        // 递归 - 真的不会超时吗
//        int len = cost.length;
//        return Math.min(helpler(cost, len-2), helpler(cost, len-1));
    }

//    private void helper(int[] cost, int i, int[] dp){
//        if (i < 2){
//            dp[i] = cost[i];
//        }
//        else if (dp[i] == 0){
//            helper(cost, i-2, dp);
//            helper(cost, i-1, dp);
//            dp[i] = Math.min(dp[i-2], dp[i-1])+cost[i];
//        }
//    }

//    // 递归
//    private int helpler(int[] cost, int i){
//        if (i < 2){
//            return cost[i];
//        }
//        return Math.min(helpler(cost, i-2), helpler(cost, i-1))+cost[i];
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
