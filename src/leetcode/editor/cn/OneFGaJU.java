//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 
//不重复 的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/ 
// Related Topics 数组 双指针 排序 👍 27 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 存放结果
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length >= 3){
            // 先排序
            Arrays.sort(nums);
            // 先用i指向一位数字
            int i = 0;
            while (i < nums.length - 2){
                twoSum(nums, i, res);
                // 重复的元素跳过
                int temp = nums[i];
                while (nums[i] == temp && i < nums.length-2){
                    i++;
                }

            }
        }

        return res;

    }

    private void twoSum(int[] nums, int i, List<List<Integer>> res){
        int j = i+1;
        int k = nums.length-1;
        while (j < k){
            if (nums[i] + nums[j] + nums[k] == 0){
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                // 重复的元素跳过
                int temp = nums[j];
                while (nums[j] == temp && j < k){
                    j++;
                }
            }
            else if (nums[i] + nums[j] + nums[k] < 0){
                j++;
            }
            else{
                k--;
            }
        }


    }


}
//leetcode submit region end(Prohibit modification and deletion)
