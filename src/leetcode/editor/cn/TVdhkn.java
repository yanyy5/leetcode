//给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// 
//
// 注意：本题与主站 78 题相同： https://leetcode-cn.com/problems/subsets/ 
// Related Topics 位运算 数组 回溯 👍 10 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        // 方法3：回溯
        List<List<Integer>> result = new LinkedList<>();
        backTrack(nums, result, new LinkedList<>(), 0);
        return result;



//        // 方法2：遍历每个元素，直接扩大一半
//        List<List<Integer>> result = new LinkedList<List<Integer>>();
//        result.add(new LinkedList<Integer>());
//        for (int i = 0; i < nums.length; i++){
//            int length = result.size();
//            for (int j = 0; j < length; j++){
//                List<Integer> tmp = new LinkedList<>(result.get(j));
//                tmp.add(nums[i]);
//                result.add(tmp);
//            }
//        }
//        return result;


//        // 方法1：迭代
//        List<Integer> tmp = new LinkedList<>();
//        List<List<Integer>> result = new LinkedList<List<Integer>>();
//        int n = nums.length;
//        for (int mask = 0; mask < (1<<n); mask++){
//            tmp.clear();
//            for (int i = 0; i < n; i++){
//                if ((mask & (1<<i)) != 0){
//                    tmp.add(nums[i]);
//                }
//            }
//            result.add(new LinkedList<Integer>(tmp));
//        }
//        return result;


    }

    private void backTrack(int[] nums, List<List<Integer>> result, List<Integer> subset, int index){
        if (index == nums.length){
            result.add(new LinkedList<>(subset));
        }
        else if (index < nums.length){
            // 不加
            backTrack(nums, result, subset, index+1);
            // 加
            subset.add(nums[index]);
            backTrack(nums, result, subset, index+1);
            subset.remove(subset.size()-1);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
