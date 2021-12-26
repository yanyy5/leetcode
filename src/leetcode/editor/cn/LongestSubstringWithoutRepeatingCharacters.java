//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6613 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }

        int left = -1, right = 0;
        int count = 0;
        int result = 1;
        int[] map = new int[256];
        for (; right < s.length(); right++){

            map[s.charAt(right)]++;
            if (map[s.charAt(right)] == 2){
                count++;
            }
            while (count>0){
                left++;
                map[s.charAt(left)]--;
                if (map[s.charAt(left)] == 1){
                    count--;
                }
            }
            result = Math.max(result, right-left);
        }
        return result;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
