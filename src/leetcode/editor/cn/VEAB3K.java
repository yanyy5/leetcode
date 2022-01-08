//存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。 
//
// 给定一个二维数组 graph ，表示图，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于 graph[u] 中的每个 v 
//，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性： 
//
// 
// 不存在自环（graph[u] 不包含 u）。 
// 不存在平行边（graph[u] 不包含重复值）。 
// 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图） 
// 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。 
// 
//
// 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称
//为 二分图 。 
//
// 如果图是二分图，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
//输出：false
//解释：不能将节点分割成两个独立的子集，以使每条边都连通一个子集中的一个节点与另一个子集中的一个节点。 
//
// 示例 2： 
//
// 
//
// 
//输入：graph = [[1,3],[0,2],[1,3],[0,2]]
//输出：true
//解释：可以将节点分成两组: {0, 2} 和 {1, 3} 。 
//
// 
//
// 提示： 
//
// 
// graph.length == n 
// 1 <= n <= 100 
// 0 <= graph[u].length < n 
// 0 <= graph[u][i] <= n - 1 
// graph[u] 不会包含 u 
// graph[u] 的所有值 互不相同 
// 如果 graph[u] 包含 v，那么 graph[v] 也会包含 u 
// 
//
// 
//
// 注意：本题与主站 785 题相同： https://leetcode-cn.com/problems/is-graph-bipartite/ 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 9 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] binary = new int[n];
        Arrays.fill(binary, -1);
        for (int i = 0; i < n; i++){
            if (binary[i] == -1){
                if (!setColor(graph, binary, i, 0)){
                    return false;
                }
            }
        }
        return true;

//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(0);
//        while(!queue.isEmpty()){
//            int i = queue.poll();
//            if (graph[i].length == 0){
//                visited[i] = true;
//                if (queue.isEmpty()){
//                    int nextVisit = next(visited);
//                    if (nextVisit != -1){
//                        queue.offer(nextVisit);
//                    }
//                }
//            }
//            else{
//                if (!bin(graph, binary, visited, i)){
//                    return false;
//                }
//                int[] next = graph[i];
//                for (int j = 0; j < next.length; j++){
//                    if (!visited[next[j]]){
//                        queue.offer(next[j]);
//                    }
//                }
//            }
//
//        }
//        return true;
    }

    private boolean setColor(int[][] graph, int[] binary, int index, int color){
        if (binary[index] >= 0){
            return binary[index] == color;
        }
        binary[index] = color;
        for (int neighbor : graph[index]){
            if (!setColor(graph, binary, neighbor, 1-color)){
                return false;
            }
        }
        return true;
    }

    private boolean setColor(int[][] graph, int[] binary, int index, int color){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        binary[index] = color;
        while (!queue.isEmpty()){
            int v = queue.poll();
            for (int neighbor : graph[v]){
                if (binary[neighbor] >= 0){
                    if (binary[neighbor] == binary[v]){
                        return false;
                    }
                }
                else{
                    queue.offer(neighbor);
                    binary[neighbor] = 1-binary[v];
                }
            }
        }
        return true;

    }


//    private int next(boolean[] visited){
//        for (int i = 0; i < visited.length; i++){
//            if (!visited[i]){
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    private boolean bin(int[][] graph, int[] binary, boolean[] visited, int i){
//        visited[i] = true;
//        if (binary[i] == 0){
//            binary[i] = 1;
//        }
//        int[] next = graph[i];
//        for (int j = 0; j < next.length; j++){
//            if (binary[next[j]] == 0){
//                binary[next[j]] = -binary[i];
//            }
//            else{
//                if (binary[i] == binary[next[j]]){
//                    return false;
//                }
//            }
//        }
//        return true;
//
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
