//正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// 
//
// 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/ 
// Related Topics 字符串 动态规划 回溯 👍 14 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backTrack(n, n, "", result);
        return result;
    }

    private void backTrack(int left, int right, String subset, List<String> result){
        if (left == 0 & right == 0){
            result.add(subset);
            return;
        }
        if (left > 0){
            backTrack(left-1, right, subset+"(", result);
        }
        if (left < right){
            backTrack(left, right-1, subset+")", result);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
