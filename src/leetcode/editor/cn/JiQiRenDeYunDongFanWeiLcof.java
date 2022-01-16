//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 415 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {

        if (k == 0){
            return 1;
        }

        // bfs
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dists = {{1,0},{0,1}};
        int count = 0;
        queue.offer(new int[]{0, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            count++;
            for (int[] dist : dists){
                int r = cur[0]+dist[0];
                int c = cur[1]+dist[1];
                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] && sum(r,c)<=k){
                    queue.offer(new int[]{r,c});
                    visited[r][c] = true;
                }
            }
        }
        return count;


    }

    private int sum(int r, int c){
        return splitSum(r)+splitSum(c);
    }

    private int splitSum(int i){
        int num = i;
        int result = 0;
        while(num > 0){
            int add = num % 10;
            num /= 10;
            result += add;
        }
        return result;
    }




}
//leetcode submit region end(Prohibit modification and deletion)
