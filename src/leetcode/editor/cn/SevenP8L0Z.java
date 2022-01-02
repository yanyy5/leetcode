//给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// 
//
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 
// Related Topics 数组 回溯 👍 11 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
            Set<Integer> set = new HashSet<>();
            for (int i = index; i < nums.length; i++){
                if (!set.contains(nums[i])){
                    set.add(nums[i]);
                    swap(nums, index,i);
                    backTrack(nums, index+1, result);
                    swap(nums, index, i);
                }
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
