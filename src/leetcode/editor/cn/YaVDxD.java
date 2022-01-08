//给定一个正整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// 
//
// 注意：本题与主站 494 题相同： https://leetcode-cn.com/problems/target-sum/ 
// Related Topics 数组 动态规划 回溯 👍 8 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        // 骚操作
        // p-q=target, p+q=sum, p=(target+sum)/2
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if (sum < target || (sum+target)%2 == 1){
            return 0;
        }
        int p = (target+sum)/2;
        int[] dp = new int[p+1];
        dp[0] = 1;
        for(int i = 1; i <= nums.length; i++){
            for (int j = p; j >= nums[i-1]; j--){
                dp[j] += dp[j-nums[i-1]];
            }
        }
        return dp[p];


//        // 我的方法
//        if (target < 0){
//            target = -target;
//        }
//        int sum = 0;
//        for (int num : nums){
//            sum += num;
//        }
//        if (target > sum){
//            return 0;
//        }
//
//        int[][] dp = new int[nums.length][sum+1];
//        for(int i = 0; i <= sum; i++){
//            if (nums[0] == 0){
//                dp[0][i] = nums[0] == i ? 2 : 0;
//            }
//            else{
//                dp[0][i] = nums[0] == i ? 1 : 0;
//            }
//
//        }
//        for(int i = 1; i < nums.length; i++){
//            for (int j = 0; j <= sum; j++){
//                if (nums[i] == 0){
//                    dp[i][j] = dp[i-1][j] * 2;
//                }
//                else{
//                    dp[i][j] = dp[i-1][Math.abs(j-nums[i])];
//                    if (j+nums[i]<=sum){
//                        dp[i][j] += dp[i-1][j+nums[i]];
//                    }
//                }
//            }
//        }
//        return dp[nums.length-1][target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
