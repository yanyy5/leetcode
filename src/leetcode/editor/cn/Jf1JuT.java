//现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。 
//
// 给定一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。 
//
// 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种
// 顺序即可。 
//
// 字符串 s 字典顺序小于 字符串 t 有两种情况： 
//
// 
// 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。 
// 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["wrt","wrf","er","ett","rftt"]
//输出："wertf"
// 
//
// 示例 2： 
//
// 
//输入：words = ["z","x"]
//输出："zx"
// 
//
// 示例 3： 
//
// 
//输入：words = ["z","x","z"]
//输出：""
//解释：不存在合法字母顺序，因此返回 "" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 269 题相同： https://leetcode-cn.com/problems/alien-dictionary/ 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 数组 字符串 👍 9 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegrees = new int[26];
        Arrays.fill(inDegrees, -1);

        for (String word : words){
            for (char ch : word.toCharArray()){
                graph.putIfAbsent(ch, new HashSet<Character>());
                inDegrees[ch-'a'] = 0;
            }
        }
        // initialize indegree
        for (int i = 1; i < words.length; i++){
            String w1 = words[i-1];
            String w2 = words[i];
            if (w1.startsWith(w2) && !w1.equals(w2)){
                return "";
            }
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++){
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                if (ch1 != ch2){
                    if (!graph.get(ch1).contains(ch2)){
                        graph.get(ch1).add(ch2);
                        inDegrees[ch2-'a']++;
                    }
                    break;
                }
            }
        }

        // topology
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++){
            if (inDegrees[i] == 0){
                queue.offer((char)('a'+i));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()){
            char ch = queue.poll();
            builder.append(ch);
            for (char next : graph.get(ch)){
                inDegrees[next-'a']--;
                if (inDegrees[next-'a'] == 0){
                    queue.offer(next);
                }
            }
        }

        return builder.length() == graph.size() ?
                builder.toString() : "";

    }
}
//leetcode submit region end(Prohibit modification and deletion)
