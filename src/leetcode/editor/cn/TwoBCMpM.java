//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
//
// 
//
// 注意：本题与主站 542 题相同：https://leetcode-cn.com/problems/01-matrix/ 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 7 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (mat[i][j] == 0){
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
                else{
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] neighbors = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()){
            int[] v = queue.poll();
            int dist = result[v[0]][v[1]];
            for (int[] neighbor : neighbors){
                int row = v[0]+neighbor[0];
                int col = v[1]+neighbor[1];
                if (row >= 0 && row < m && col >= 0 && col < n){
                    if (dist+1 < result[row][col]){
                        result[row][col] = dist+1;
                        queue.offer(new int[]{row, col});
                    }
                }
            }
        }


        return result;


    }

//    private int bfs(int[][] mat, int[][] result, int i, int j, int layer){
////        visited[i][j] = true;
//        Queue<int[]> queue = new LinkedList<>();
//        int[][] neighbors = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
//        for (int[] neighbor : neighbors){
//            int row = i+neighbor[0];
//            int col = j+neighbor[1];
//            if (row >= 0 && row < mat.length && col >= 0 && col < mat[0].length){
//                if (mat[row][col] == 0){
//                    result[i][j] = layer+1;
//                    return layer+1;
//                }
//                else{
//                    queue.offer(new int[]{row, col});
//                }
//            }
//        }
//        while (!queue.isEmpty()){
//            int[] v = queue.poll();
//
//        }
//
//
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
