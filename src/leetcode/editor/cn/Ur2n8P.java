//请判断原始的序列 org 是否可以从序列集 seqs 中唯一地 重建 。 
//
// 序列 org 是 1 到 n 整数的排列，其中 1 ≤ n ≤ 10⁴。重建 是指在序列集 seqs 中构建最短的公共超序列，即 seqs 中的任意序列都
//是该最短序列的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入: org = [1,2,3], seqs = [[1,2],[1,3]]
//输出: false
//解释：[1,2,3] 不是可以被重建的唯一的序列，因为 [1,3,2] 也是一个合法的序列。
// 
//
// 示例 2： 
//
// 
//输入: org = [1,2,3], seqs = [[1,2]]
//输出: false
//解释：可以重建的序列只有 [1,2]。
// 
//
// 示例 3： 
//
// 
//输入: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
//输出: true
//解释：序列 [1,2], [1,3] 和 [2,3] 可以被唯一地重建为原始的序列 [1,2,3]。
// 
//
// 示例 4： 
//
// 
//输入: org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
//输出: true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// org 是数字 1 到 n 的一个排列 
// 1 <= segs[i].length <= 10⁵ 
// seqs[i][j] 是 32 位有符号整数 
// 
//
// 
//
// 注意：本题与主站 444 题相同：https://leetcode-cn.com/problems/sequence-reconstruction/ 
// Related Topics 图 拓扑排序 数组 👍 7 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] indegree = new int[org.length];
        Arrays.fill(indegree, -1);
        for (int i = 1; i < org.length+1; i++){
            graph.put(i, new HashSet<Integer>());
        }
        for (List<Integer> seq : seqs){
            for (Integer se : seq){
                if ((se-1)>= org.length || (se-1)<0){
                    return false;
                }
                indegree[se-1] = 0;
            }
        }
        for (int in : indegree){
            if (in == -1){
                return false;
            }
        }

        for (int i = 0; i < seqs.size(); i++){
            List<Integer> cur = seqs.get(i);
            for (int j = 0; j < seqs.get(i).size()-1; j++){
                if (!graph.get(cur.get(j)).contains(cur.get(j+1))){
                    graph.get(cur.get(j)).add(cur.get(j+1));
                    indegree[cur.get(j+1)-1]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0){
                queue.offer(i+1);
            }
        }
        if (queue.size() > 1){
            return false;
        }
        int count = 0;
        List<Integer> tmp = new LinkedList<>();
        while (!queue.isEmpty()){
            int num = queue.poll();
            if (num != org[count++]){
                return false;
            }
            tmp.add(num);
            for (Integer neighbor : graph.get(num)){
                indegree[neighbor-1]--;
                if (indegree[neighbor-1] == 0){
                    queue.offer(neighbor);
                }
            }
            if (queue.size() > 1){
                return false;
            }
        }
        return tmp.size() == org.length;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
