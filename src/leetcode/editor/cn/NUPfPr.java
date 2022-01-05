//给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：nums 可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：nums 不可以分为和相等的两部分
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// 
//
// 注意：本题与主站 416 题相同： https://leetcode-cn.com/problems/partition-equal-subset-
//sum/ 
// Related Topics 数学 字符串 模拟 👍 19 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }

        int target = sum / 2;

        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int i = 1; i < nums.length+1; i++){
            for (int j = target; j > 0; j--){
                if (!dp[j] && j >= nums[i-1]){
                    dp[j] = dp[j-nums[i-1]];
                }
            }
        }
        return dp[target];



//        boolean[][] dp = new boolean[nums.length+1][target+1];
//        for(int i = 0; i < nums.length+1; i++){
//            dp[i][0] = true;
//        }
//        for(int i = 1; i < nums.length+1; i++){
//            for (int j = 1; j < target+1; j++){
//                dp[i][j] = dp[i-1][j];
//                if (!dp[i][j] && j >= nums[i-1]){
//                    dp[i][j] = dp[i-1][j-nums[i-1]];
//                }
//            }
//        }
//        return dp[nums.length][target];


//        // 递归版本
//        Boolean[][] dp = new Boolean[nums.length+1][target+1];
//        return helper(nums, dp, nums.length, target);


    }

//    private boolean helper(int[] nums, Boolean[][] dp, int i, int j){
//        if (dp[i][j] == null){
//            if (j == 0){
//                dp[i][j] = true;
//            }
//            else if (i == 0){
//                dp[i][j] = false;
//            }
//            else{
//                dp[i][j] = helper(nums, dp, i-1, j);
//                if (!dp[i][j] && j >= nums[i-1]){
//                    dp[i][j] = helper(nums, dp, i-1, j-nums[i-1]);
//                }
//            }
//        }
//        return dp[i][j];
//    }



}
//leetcode submit region end(Prohibit modification and deletion)
