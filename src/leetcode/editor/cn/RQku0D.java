//给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 可以删除 "c" 字符 或者 "b" 字符
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/ 
// Related Topics 贪心 双指针 字符串 👍 16 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() == 1){
            return true;
        }

        int left = 0;
        int right = s.length()-1;

        for (; left < s.length()/2; left++, right--){
            if (s.charAt(left) != s.charAt(right)){
                break;
            }
        }

        if (left == s.length()/2){
            return true;
        }
        else {
            return secondValidate(s, left+1, right) || secondValidate(s, left, right-1);
        }

    }

    private boolean secondValidate(String s, int start, int end){

        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            else {
                start++;
                end--;
            }
        }
        return true;


    }

}
//leetcode submit region end(Prohibit modification and deletion)
