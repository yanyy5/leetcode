//一个密码锁由 4 个环形拨轮组成，每个拨轮都有 10 个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', 
//'9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，请给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，因为当拨动到 "0102" 时这
//个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：
//把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//输出：-1
//解释：
//无法旋转到目标数字且不被锁定。
// 
//
// 示例 4: 
//
// 
//输入: deadends = ["0000"], target = "8888"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
//
// 
//
// 注意：本题与主站 752 题相同： https://leetcode-cn.com/problems/open-the-lock/ 
// Related Topics 广度优先搜索 数组 哈希表 字符串 👍 4 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int openLock(String[] deadends, String target) {

        Queue<String> queue = new LinkedList<>();
        Set<String> dead = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String d : deadends){
            if (d.equals("0000") || d.equals(target)){
                return -1;
            }
            else{
                dead.add(d);
            }
        }
        queue.offer(target);
        visited.add(target);
        int count = 1;
        int next = 0;
        int length = 0;
        while (!queue.isEmpty()){
            String word = queue.poll();
            count--;
            if (word.equals("0000")){
                return length;
            }
            String[] neighbors = getNeighbors(word);
            for (String neighbor : neighbors){
                if (!dead.contains(neighbor) && !visited.contains(neighbor)){
                    queue.offer(neighbor);
                    visited.add(neighbor);
                    next++;
                }
            }
            if (count == 0){
                length++;
                count = next;
                next = 0;
            }
        }
        return -1;



    }

    private String[] getNeighbors(String word){
        String[] neighbors = new String[8];
        char[] ch = word.toCharArray();
        for (int i = 0; i < 4; i++){
            char old = ch[i];
            if (old == '0'){
                ch[i] = '1';
                neighbors[i*2] = new String(ch);
                ch[i] = '9';
                neighbors[i*2+1] = new String(ch);
            }
            else if (old == '9'){
                ch[i] = '8';
                neighbors[i*2] = new String(ch);
                ch[i] = '0';
                neighbors[i*2+1] = new String(ch);
            }
            else{
                ch[i] = (char)(old-1);
                neighbors[i*2] = new String(ch);
                ch[i] = (char)(old+1);
                neighbors[i*2+1] = new String(ch);
            }
            ch[i] = old;
        }
        return neighbors;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
