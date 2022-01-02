//给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
//。 
//
// candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// 
//
// 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/ 
// Related Topics 数组 回溯 👍 11 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        quickSort(candidates, 0, candidates.length-1);

        List<List<Integer>> result = new ArrayList<>();
        backTrack(0, candidates, target, new ArrayList<>(), result);
        return result;
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

    private void backTrack(int index, int[] candidates, int target, List<Integer> subset, List<List<Integer>> result){
        if (target == 0){
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = index; i < candidates.length; i++){
            if (target-candidates[i]<0){
                break;
            }
            if (i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            subset.add(candidates[i]);
            backTrack(i+1, candidates, target-candidates[i], subset, result);
            subset.remove(subset.size()-1);
        }

//        // 不加
//        backTrack(index+1, candidates, target, subset, result);
//        // 加
//        if (target-candidates[index] >= 0){
//            subset.add(candidates[index]);
//            backTrack(index+1, candidates, target-candidates[index], subset, result);
//            subset.remove(subset.size()-1);
//        }



    }

}
//leetcode submit region end(Prohibit modification and deletion)
