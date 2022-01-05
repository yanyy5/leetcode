//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
// 
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 
//
// 示例 3： 
//
// 
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 和 text2 仅由小写英文字符组成。 
// 
//
// 
//
// 注意：本题与主站 1143 题相同： https://leetcode-cn.com/problems/longest-common-
//subsequence/ 
// Related Topics 字符串 动态规划 👍 31 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        // 一维数组，天秀版本
        int len1 = text1.length();
        int len2 = text2.length();

        if (len1<len2){
            return longestCommonSubsequence(text2, text1);
        }

        int[] dp = new int[len2+1];
        for (int i = 0; i < len1; i++){
            int prev = dp[0];
            for(int j = 0; j < len2; j++){
                int cur;
                if(text1.charAt(i) == text2.charAt(j)){
                    cur = prev + 1;
                }
                else{
                    cur = Math.max(dp[j], dp[j+1]);
                }
                prev = dp[j+1];
                dp[j+1] = cur;
            }
        }

        return dp[len2];


//        // 先来一个最初级啰嗦的版本
//        int len1 = text1.length();
//        int len2 = text2.length();
//
//        int[][] dp = new int[len1+1][len2+1];
//        for(int i = 0; i < len1; i++){
//            for(int j = 0; j < len2; j++){
//                if (text1.charAt(i) == text2.charAt(j)){
//                    dp[i+1][j+1] = dp[i][j]+1;
//                }
//                else{
//                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
//                }
//            }
//        }
//
//        return dp[len1][len2];



    }
}
//leetcode submit region end(Prohibit modification and deletion)
