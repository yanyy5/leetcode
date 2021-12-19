//给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。 
//
// 如果 s 中存在多个符合条件的子字符串，返回任意一个。 
//
// 
//
// 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC" 
//解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C' 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3： 
//
// 
//输入：s = "a", t = "aa"
//输出：""
//解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ 
//
// 
//
// 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-
//substring/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 13 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()){
            return "";
        }
        if (s.equals(t)){
            return t;
        }

        // map
        HashMap<Character, Integer> map = new HashMap<>();

        // init
        for (char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int left = 0, right = 0, minLeft = 0, minRight = 0;
        int minLength = Integer.MAX_VALUE;
        int count = map.size();

        while (right < s.length() || (right == s.length() && count == 0)){
            if (count > 0){
                // 子字符串还没满足要求
                char endCh = s.charAt(right);
                if (map.containsKey(endCh)){
                    map.put(endCh, map.get(endCh)-1);
                    if (map.get(endCh) == 0){
                        count--;
                    }
                }
                right++;
            }
            else{
                // 子字符串包含了t的所有字符，但不一定是最短
                if (right - left < minLength){
                    minLength = right - left;
                    minLeft = left;
                    minRight = right;
                }
                char startCh = s.charAt(left);
                if (map.containsKey(startCh)){
                    map.put(startCh, map.get(startCh)+1);
                    if (map.get(startCh) == 1){
                        count++;
                    }
                }
                left++;
            }
        }

        return minLength < Integer.MAX_VALUE ? s.substring(minLeft, minRight) : "";



    }
}
//leetcode submit region end(Prohibit modification and deletion)
