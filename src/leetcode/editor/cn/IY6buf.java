//给定三个字符串 s1、s2、s3，请判断 s3 能不能由 s1 和 s2 交织（交错） 组成。 
//
// 两个字符串 s 和 t 交织 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交织 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 97 题相同： https://leetcode-cn.com/problems/interleaving-string/ 
// Related Topics 字符串 动态规划 👍 6 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length()+s2.length() != s3.length()){
            return false;
        }

        if (s1.length() < s2.length()){
            return isInterleave(s2, s1, s3);
        }

        boolean[] dp = new boolean[s2.length()+1];
        dp[0] = true;

//        for (int i = 0; i < s1.length(); i++){
//            dp[i+1][0] = s1.charAt(i) == s3.charAt(i) && dp[i][0];
//        }
        // 只考虑了没有i的情况
        for (int j = 0; j < s2.length(); j++){
            dp[j+1] = s2.charAt(j) == s3.charAt(j) && dp[j];
        }

        for(int i = 0; i < s1.length(); i++){
            dp[0] = s1.charAt(i) == s3.charAt(i) && dp[0];
            for (int j = 0; j < s2.length(); j++){
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                char ch3 = s3.charAt(i+j+1);
                dp[j+1] = (ch1 == ch3 && dp[j+1]) || (ch2 == ch3 && dp[j]);
            }
        }

        return dp[s2.length()];



    }
}
//leetcode submit region end(Prohibit modification and deletion)
