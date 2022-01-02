//给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "google"
//输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出：[["a"]  
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 131 题相同： https://leetcode-cn.com/problems/palindrome-partitioning/ 
// Related Topics 字符串 动态规划 回溯 👍 13 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[][] partition(String s) {
        List<List<String>> result = new LinkedList<>();
        backTrack(s, 0, new LinkedList<String>(), result);
        String[][] str = new String[result.size()][];
        int i = 0;
        for (List<String> subList : result){
            str[i++] = subList.toArray(new String[subList.size()]);
        }
        return str;
    }

    private void backTrack(String s, int index, LinkedList<String> subset, List<List<String>> result){
        if (index == s.length()){
            result.add(new LinkedList<>(subset));
            return;
        }
        for (int i = index; i < s.length(); i++){
            if (symmetric(s, index, i)){
                subset.add(s.substring(index, i+1));
                backTrack(s, i+1, subset, result);
                subset.remove(subset.size()-1);
            }
        }
    }

    private boolean symmetric(String s, int start, int end){
        while (start < end){
            if (s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
