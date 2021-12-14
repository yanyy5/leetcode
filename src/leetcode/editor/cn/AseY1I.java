//给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语
//的小写字母。如果没有不包含相同字符的一对字符串，返回 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
//输出: 16 
//解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。 
//
// 示例 2: 
//
// 
//输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
//输出: 4 
//解释: 这两个单词为 "ab", "cd"。 
//
// 示例 3: 
//
// 
//输入: words = ["a","aa","aaa","aaaa"]
//输出: 0 
//解释: 不存在这样的两个单词。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 318 题相同：https://leetcode-cn.com/problems/maximum-product-of-word-
//lengths/ 
// Related Topics 位运算 数组 字符串 👍 26 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(String[] words) {

        // 方法2：用int的二进制数位记录字符a-z是否出现
        // flags初始化
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++){
            for (char c : words[i].toCharArray()){
                // 意思为当前flag和某位为1的数字进行与操作（相当于把那1位变成1）
                flags[i] |= 1 << (c - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < words.length-1; i++){
            for (int j = i+1; j < words.length; j++){
                if ((flags[i] & flags[j]) == 0){
                    // 说明每一位都不相同
                    int prod = words[i].length() * words[j].length();
                    res = Math.max(prod, res);
                }
            }
        }
        return res;


//        // 方法1：用哈希表记录字符a-z是否出现
//        // 哈希表初始化
//        boolean[][] flags = new boolean[words.length][26];
//        for (int i = 0; i < words.length; i++){
//            for (char c : words[i].toCharArray()){
//                flags[i][c - 'a'] = true;
//            }
//        }
//        // 两两比较
//        int res = 0;
//        for (int i = 0; i < words.length-1; i++){
//            for (int j = i+1; j < words.length; j++){
//                int k = 0;
//                while(k < 26){
//                    if (flags[i][k] && flags[j][k]){
//                        break;
//                    }
//                    k++;
//                }
//                // k = 26说明两个字符串没有重复的部分
//                if (k == 26){
//                    // 计算当前两字符串长度的乘积
//                    int prod = words[i].length() * words[j].length();
//                    res = Math.max(prod, res);
//                }
//            }
//        }
//        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
