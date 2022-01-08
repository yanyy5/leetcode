//给定一个有 n 个节点的有向无环图，用二维数组 graph 表示，请找到所有从 0 到 n-1 的路径并输出（不要求按顺序）。 
//
// graph 的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ），若
//为空，就是没有下一个节点了。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：graph = [[1,2],[3],[3],[]]
//输出：[[0,1,3],[0,2,3]]
//解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
// 
//
// 示例 2： 
//
// 
//
// 
//输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
//输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
// 
//
// 示例 3： 
//
// 
//输入：graph = [[1],[]]
//输出：[[0,1]]
// 
//
// 示例 4： 
//
// 
//输入：graph = [[1,2,3],[2],[3],[]]
//输出：[[0,1,2,3],[0,2,3],[0,3]]
// 
//
// 示例 5： 
//
// 
//输入：graph = [[1,3],[2],[3],[]]
//输出：[[0,1,2,3],[0,3]]
// 
//
// 
//
// 提示： 
//
// 
// n == graph.length 
// 2 <= n <= 15 
// 0 <= graph[i][j] < n 
// graph[i][j] != i 
// 保证输入为有向无环图 (GAD) 
// 
//
// 
//
// 注意：本题与主站 797 题相同：https://leetcode-cn.com/problems/all-paths-from-source-to-
//target/ 
// Related Topics 深度优先搜索 广度优先搜索 图 回溯 👍 11 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> subset = new LinkedList<>();
        subset.add(0);
        dfs(graph, subset, result, 0);
        return result;
    }

    private void dfs(int[][] graph, List<Integer> subset, List<List<Integer>> result, int index){
        if (index == graph.length-1){
            result.add(new LinkedList<>(subset));
            return;
        }
        else {
            for (int i = 0; i < graph[index].length; i++){
                subset.add(graph[index][i]);
                dfs(graph, subset, result, graph[index][i]);
                subset.remove(subset.size()-1);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
