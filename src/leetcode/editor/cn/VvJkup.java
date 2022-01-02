//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// 
//
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 
// Related Topics 数组 回溯 👍 9 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backTrack(nums, 0, result);
        return result;
    }

    private void backTrack(int[] nums, int index, List<List<Integer>> result){
        if (index == nums.length){
            List<Integer> list = new LinkedList<>();
            for (int num : nums){
                list.add(num);
            }
            result.add(list);
        }
        else{
            for (int i = index; i < nums.length; i++){
                swap(nums, i, index);
                backTrack(nums, index+1, result);
                swap(nums, i, index);
            }
        }

    }

    private void swap(int[] nums, int i, int j){
        if (i != j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
