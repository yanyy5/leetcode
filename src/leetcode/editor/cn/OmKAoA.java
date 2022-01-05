//给定一个字符串 s，请将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
//
// 
//
// 注意：本题与主站 132 题相同： https://leetcode-cn.com/problems/palindrome-partitioning-
//ii/ 
// Related Topics 字符串 动态规划 👍 9 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCut(String s) {

        // 先把子字符串是否是回文保存在一个二维数组，降低时间复杂度
        int len = s.length();
        boolean[][] isPal = new boolean[len][len];
        for (int i = 0; i < len; i++){
            for (int j = 0; j <=i; j++){
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                if (ch1 == ch2 && (i-j<=1 || isPal[j+1][i-1])){
                    isPal[j][i] = true;
                }
            }
        }

        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++){
            if (isPal[0][i]){
                dp[i] = 0;
            }
            else{
                dp[i] = i;  // 先给一个目前最大值
                for (int j = 1; j <= i; j++){
                    if (isPal[j][i]){
                        dp[i] = Math.min(dp[i], dp[j-1]+1);
                    }
                }
            }
        }
        return dp[len-1];

    }


}
//leetcode submit region end(Prohibit modification and deletion)
