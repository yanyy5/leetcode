//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/ 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 20 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()){
            return false;
        }

        // hashmap
        int[] map = new int[26];

        // init
        for (int i = 0; i < s1.length(); i++){
            map[s1.charAt(i) - 'a']++;
            map[s2.charAt(i) - 'a']--;
        }
        if (isZero(map)){
            return true;
        }

        // move two pointers
        // i is right pointer
        for (int i = s1.length(); i < s2.length(); i++){
            map[s2.charAt(i)-'a']--;
            map[s2.charAt(i-s1.length())-'a']++;
            if (isZero(map)){
                return true;
            }
        }
        return false;
    }

    private boolean isZero(int[] map){
        for (int num : map){
            if (num != 0){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
