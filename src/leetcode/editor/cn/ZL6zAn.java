//给定一个由 0 和 1 组成的非空二维数组 grid ，用来表示海洋岛屿地图。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1
//,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0
//,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出: 6
//解释: 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// 
//输入: grid = [[0,0,0,0,0,0,0,0]]
//输出: 0 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] is either 0 or 1 
// 
//
// 
//
// 注意：本题与主站 695 题相同： https://leetcode-cn.com/problems/max-area-of-island/ 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 19 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;

        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    int area = getArea(grid, visited, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    // dfs 版本
    private int getArea(int[][] grid, boolean[][] visited, int i, int j){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        visited[i][j] = true;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int area = 0;
        while (!stack.isEmpty()){
            int[] pos = stack.pop();
            area++;

            for (int[] dir : dirs){
                int r = pos[0]+dir[0];
                int c = pos[1]+dir[1];
                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length
                        && grid[r][c] == 1 && !visited[r][c]){
                    stack.push(new int[]{r, c});
                    visited[r][c] = true;
                }
            }

        }
        return area;
    }


    // bfs 版本
    private int getArea(int[][] grid, boolean[][] visited, int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int area = 0;
        while (!queue.isEmpty()){
            int[] pos = queue.poll();
            area++;

            for (int[] dir : dirs){
                int r = pos[0]+dir[0];
                int c = pos[1]+dir[1];
                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length
                        && grid[r][c] == 1 && !visited[r][c]){
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }

        }
        return area;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
