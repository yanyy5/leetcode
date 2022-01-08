//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 注意：本题与主站 128 题相同： https://leetcode-cn.com/problems/longest-consecutive-
//sequence/ 
// Related Topics 并查集 数组 哈希表 👍 14 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0){
            return 0;
        }
        Map<Integer, Integer> fathers = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        Set<Integer> all = new HashSet<>();
        int result = 1;
        for (int i = 0; i < nums.length; i++){
            counts.put(nums[i], 1);
            fathers.put(nums[i], nums[i]);
            all.add(nums[i]);
        }
        for (int num : nums){
            if (all.contains(num+1)){
                union(fathers, counts, num, num+1);
            }
            if (all.contains(num-1)){
                union(fathers, counts, num-1, num);
            }
        }

        for (int value : counts.values()){
            result = Math.max(result, value);
        }


        return result;


    }

    private int findFather(Map<Integer, Integer> fathers, int i){

        if (fathers.get(i) != i){
            int f = findFather(fathers, fathers.get(i));
            fathers.put(i, f);
        }
        return fathers.get(i);

    }

    private void union(Map<Integer, Integer> fathers, Map<Integer, Integer> counts, int i, int j){
        if (i > j){
            union(fathers, counts, j, i);
        }
        else{
            int fi = findFather(fathers, i);
            int fj = findFather(fathers, j);
            if (fi != fj){
                fathers.put(fi, fj);
                counts.put(fj, counts.get(fj)+counts.get(fi));
            }
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)
