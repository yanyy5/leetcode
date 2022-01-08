//
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
//
// 
//
// 注意：本题与主站 547 题相同： https://leetcode-cn.com/problems/number-of-provinces/ 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 23 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {

        // 并查集
        int[] fathers = new int[isConnected.length];
        for (int i = 0; i < fathers.length; i++){
            fathers[i] = i; // 初始化n个子集，每个节点的根节点都是自己
        }

        int count = isConnected.length;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i+1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && union(fathers, i, j)){
                    count--;
                }
            }
        }
        return count;



//        // 图的搜索，bfs/dfs
//        boolean[] visited = new boolean[isConnected.length];
//        int result = 0;
//        for (int i = 0; i < isConnected.length; i++){
//            if (!visited[i]){
////                bfs(isConnected, visited, i);
//                dfs(isConnected, visited, i);
//                result++;
//            }
//        }
//        return result;

    }

    // 寻找根节点
    private int findFather(int[] fathers, int i){
        if (fathers[i] != i){
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }

    private boolean union(int[] fathers, int i, int j){
        int fi = findFather(fathers, i);
        int fj = findFather(fathers, j);
        if (fi != fj){
            fathers[fi] = fj;
            return true;
        }
        return false;
    }

//    private void dfs(int[][] isConnected, boolean[] visited, int i){
//        visited[i] = true;
//        for (int city = 0; city < isConnected.length; city++){
//            if (isConnected[i][city] == 1 && !visited[city]){
//                dfs(isConnected, visited, city);
//            }
//        }
//    }
//
//    private void bfs(int[][] isConnected, boolean[] visited, int i){
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(i);
//        visited[i] = true;
//        while (!queue.isEmpty()){
//            int t = queue.remove();
//            for (int city = 0; city < isConnected.length; city++){
//                if (isConnected[t][city] == 1 && !visited[city]){
//                    queue.add(city);
//                    visited[city] = true;
//                }
//            }
//        }
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
