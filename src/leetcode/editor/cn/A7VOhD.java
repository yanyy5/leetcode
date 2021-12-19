//给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/ 
// Related Topics 字符串 动态规划 👍 18 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {


        // 方法2：马拉车 / Manacher
        String T = preprocess(s);
        int C = 0, R = 0, result = 0;
        int[] P = new int[T.length()-1];
        for (int i = 1; i < T.length()-1; i++){
            int iMirror = 2 * C - i;
            // 常规情况赋值
            if (i <= R){
                P[i] = Math.min(R-i, P[iMirror]);
            }
            else {
                P[i] = 0;
            }
            // 中心扩展
            while (T.charAt(i+P[i]+1) == T.charAt(i-P[i]-1)){
                P[i]++;
            }
            result += (P[i]+1)/2;
            // 判断是否需要更新C和R
            if (i + P[i] > R){
                C = i;
                R = i + P[i];
            }
        }

        return result;


//        // 找出最大的P[i]
//        int maxIndex = 0;
//        int maxLength = 0;
//        for (int i = 0; i < P.length; i++){
//            if (P[i] > maxLength){
//                maxIndex = i;
//                maxLength = P[i];
//            }
//        }

//        int start = (maxIndex - maxLength) / 2;
//        return s.substring(start, start+maxLength);



//        // 方法1：中心扩展法
//        int count = 0;
//        for (int i = 0; i < s.length(); i++){
//            count += secondCheck(s, i, i);
//            count += secondCheck(s, i, i+1);
//        }
//        return count;

    }

    private String preprocess(String s){
        if (s == null || s.length() == 0){
            return "^$";
        }
        StringBuilder builder = new StringBuilder("^#");
        for (char ch : s.toCharArray()){
            builder.append(ch);
            builder.append("#");
        }
        builder.append("$");
        return builder.toString();

    }

//    private int secondCheck(String s, int start, int end){
//        int result = 0;
//        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
//            result++;
//            start--;
//            end++;
//
//        }
//        return result;
//    }


}
//leetcode submit region end(Prohibit modification and deletion)
