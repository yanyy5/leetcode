//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2
//解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
// 
//
// 示例 2 : 
//
// 
//输入:nums = [1,2,3], k = 3
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// 
// -10⁷ <= k <= 10⁷ 
// 
// 
//
// 
//
// 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/ 
// Related Topics 数组 哈希表 前缀和 👍 27 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        // 用hashmap记录累加数组的和
        Map<Integer, Integer> numsMap = new HashMap<>();
        // 初始化
        numsMap.put(0,1);

        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            // 找是否有和为sum-k的数组，有则说明存在另一个连续子数组和为k
            count += numsMap.getOrDefault(sum-k, 0);
            numsMap.put(sum, numsMap.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
