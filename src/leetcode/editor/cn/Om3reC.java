//在字典（单词列表） wordList 中，从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给定两个长度相同但内容不同的单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 
//的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
//
// 
//
// 注意：本题与主站 127 题相同： https://leetcode-cn.com/problems/word-ladder/ 
// Related Topics 广度优先搜索 哈希表 字符串 👍 4 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 双向bfs
        Set<String> notVisited = new HashSet<>(wordList);
        if (!notVisited.contains(endWord)){
            return 0;
        }

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        int length = 2;
        set1.add(beginWord);
        set2.add(endWord);
        notVisited.remove(endWord);
        while (!set1.isEmpty() && !set2.isEmpty()){
            if (set2.size() < set1.size()){
                Set<String> tmp = set1;
                set1 = set2;
                set2 = tmp;
            }
            Set<String> set3 = new HashSet<>();
            for (String word : set1){
                List<String> neighbors = getNeighbors(word);
                for (String neighbor : neighbors){
                    if (set2.contains(neighbor)){
                        return length;
                    }
                    if (notVisited.contains(neighbor)){
                        set3.add(neighbor);
                        notVisited.remove(neighbor);
                    }
                }
            }
            length++;
            set1 = set3;
        }
        return 0;



//        // 单向bfs+单队列
//        Queue<String> queue = new LinkedList<>();
//        Set<String> notVisited = new HashSet<>(wordList);
//        queue.offer(beginWord);
//        int length = 1;
//        int count = 1;
//        int next = 0;
//        while (!queue.isEmpty()){
//            String word = queue.poll();
//            count--;
//            if (word.equals(endWord)){
//                return length;
//            }
//            List<String> neighbors = getNeighbors(word);
//            for (String neighbor : neighbors){
//                if (notVisited.contains(neighbor)){
//                    queue.offer(neighbor);
//                    notVisited.remove(neighbor);
//                    next++;
//                }
//            }
//            if (count == 0){
//                length++;
//                count = next;
//                next = 0;
//            }
//        }
//        return 0;


//        // 单向bfs+双队列
//        Queue<String> queue1 = new LinkedList<>();
//        Queue<String> queue2 = new LinkedList<>();
//        Set<String> notVisited = new HashSet<>(wordList);
//
//        int length = 1;
//        queue1.offer(beginWord);
//        while (!queue1.isEmpty()){
//            String word = queue1.poll();
//            if (word.equals(endWord)){
//                return length;
//            }
//
//            List<String> neighbors = getNeighbors(word);
//            for (String neighbor : neighbors){
//                if (notVisited.contains(neighbor)){
//                    queue2.offer(neighbor);
//                    notVisited.remove(neighbor);
//                }
//            }
//
//            if (queue1.isEmpty()){
//                length++;
//                queue1 = queue2;
//                queue2 = new LinkedList<>();
//            }
//
//        }
//        return 0;


    }

    private List<String> getNeighbors(String word){
        List<String> neighbors = new LinkedList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++){
            char old = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++){
                if (old != ch){
                    chars[i] = ch;
                    neighbors.add(new String(chars));
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
