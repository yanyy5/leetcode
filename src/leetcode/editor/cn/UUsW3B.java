//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: [[1]] 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// 
//
// 注意：本题与主站 77 题相同： https://leetcode-cn.com/problems/combinations/ 
// Related Topics 数组 回溯 👍 9 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backTrack(int i, int n, int k, List<Integer> subset, List<List<Integer>> result){
        if (subset.size() == k){
            result.add(new ArrayList<>(subset));
            return;
        }
        if (i <= n){
            backTrack(i+1, n, k, subset, result);
            subset.add(i);
            backTrack(i+1, n, k, subset, result);
            subset.remove(subset.size()-1);
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
