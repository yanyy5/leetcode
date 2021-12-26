//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// 
//
// 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/ 
// Related Topics 数组 数学 字符串 排序 👍 5 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference(List<String> timePoints) {

        if (timePoints.size() > 1440){
            return 0;
        }
//        if (timePoints.size() > 720){
//            return 1;
//        }

        // 转化为分钟
        boolean[] mins = new boolean[1440];
        for (String timePoint : timePoints){
            String[] time = timePoint.split(":");
            int min = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            if (mins[min]){
                return 0;
            }
            mins[min] = true;
        }

        // find the min gap
        return findGap(mins);

    }

    private int findGap(boolean[] time){
        int left = -1, right = -1;
        int start = time.length;
        int gap = time.length;
        for (int i = 0; i < time.length; i++){
            if (time[i]){
                if (left >= 0){
                    gap = Math.min(gap, i-left);
                }
                left = i;
                start = Math.min(start, i);
                right = Math.max(right, i);
            }
        }
        gap = Math.min(gap, start+ time.length-right);
        return gap;
    }



}
//leetcode submit region end(Prohibit modification and deletion)
