//给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 84 题相同： https://leetcode-cn.com/problems/largest-rectangle-in-
//histogram/ 
// Related Topics 栈 数组 单调栈 👍 14 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {

        if (heights.length == 1){
            return heights[0];
        }

        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        // 遍历heights，确保单调栈内的元素都是升序
        for (int i = 0; i < heights.length; i++){
            while(stack.peek() != -1 && heights[stack.peek()]>=heights[i]){
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                result = Math.max(result, height*width);
            }
            stack.push(i);
        }

        // 可能stack还有剩下的
        while (stack.peek() != -1){
            int height = heights[stack.pop()];
            // 能在stack剩下，说明这个元素右边的都比它大，所以用heights.length来减
            int width = heights.length - stack.peek() - 1;
            result = Math.max(result, height*width);
        }

        return result;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
