//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 👍 335 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }

        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int r = 0, c = 0;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int dirIndex = 0;
        int[] order = new int[total];
        for (int i = 0; i < total; i++){
            order[i] = matrix[r][c];
            visited[r][c] = true;
            int nextr = r+dirs[dirIndex][0], nextc = c+dirs[dirIndex][1];
            if (nextr<0 || nextr>=rows || nextc<0 || nextc>=columns || visited[nextr][nextc]){
                dirIndex = (dirIndex+1)%4;
            }
            r += dirs[dirIndex][0];
            c += dirs[dirIndex][1];
        }
        return order;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
