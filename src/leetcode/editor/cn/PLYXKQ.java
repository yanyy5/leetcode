//给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。 
//
// 注意：此题 matrix 输入格式为一维 01 字符串数组。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = ["10100","10111","11111","10010"]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = ["0"]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = ["1"]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = ["00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// 
//
// 注意：本题与主站 85 题相同（输入参数格式不同）： https://leetcode-cn.com/problems/maximal-
//rectangle/ 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 16 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(String[] matrix) {

        if (matrix.length == 0 || matrix[0].length() == 0){
            return 0;
        }

        int[] heights = new int[matrix[0].length()];
        int result = 0;
        for (String ma : matrix){
            char[] ch = ma.toCharArray();
            for (int i = 0; i < ch.length; i++){
                heights[i] = ch[i] == '0' ? 0 : heights[i] + 1;
            }
            result = Math.max(result, calculate(heights));
        }

        return result;


    }

    // 39题的方法。。
    private int calculate(int[] heights){

        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < heights.length; i++){
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                result = Math.max(result, height*width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1){
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            result = Math.max(result, height*width);
        }

        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
