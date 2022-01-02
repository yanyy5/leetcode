//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。 
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
// 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 示例 4： 
//
// 
//输入: candidates = [1], target = 1
//输出: [[1]]
// 
//
// 示例 5： 
//
// 
//输入: candidates = [1], target = 2
//输出: [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
//
// 
//
// 注意：本题与主站 39 题相同： https://leetcode-cn.com/problems/combination-sum/ 
// Related Topics 数组 回溯 👍 12 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        quickSort(candidates, 0, candidates.length-1);
        backTrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backTrack(int index, int[] candidates, int target, List<Integer> subset, List<List<Integer>> result){
        if (index == candidates.length){
            return;
        }
        if (target == 0){
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = index; i < candidates.length; i++){
            if (target-candidates[i] < 0){
                break;
            }
            subset.add(candidates[i]);
            backTrack(i, candidates, target-candidates[i], subset, result);
            subset.remove(subset.size()-1);
        }

//        if (index < candidates.length){
//            // 不加
//            backTrack(index+1, candidates, target, subset, result);
//            // 加
//            if (target-candidates[index] >= 0){
//                subset.add(candidates[index]);
//                backTrack(index, candidates, target-candidates[index], subset, result);
//                subset.remove(subset.size()-1);
//            }
//        }


    }

    private void quickSort(int[] nums, int start, int end){
        if (start < end){
            int pivot = partition(nums, start, end);
            quickSort(nums, start, pivot-1);
            quickSort(nums, pivot+1, end);
        }
    }

    private int partition(int[] nums, int start, int end){
        int random = new Random().nextInt(end-start+1)+start;
        swap(nums, random, end);

        int small = start-1;
        for(int i = start; i < end; i++){
            if (nums[i] < nums[end]){
                small++;
                swap(nums, small, i);
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }

    private void swap(int[] nums, int index1, int index2){
        if (index1 != index2){
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
