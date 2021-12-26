//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= 
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁴ 
// 0 <= t <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 220 题相同： https://leetcode-cn.com/problems/contains-duplicate-iii/ 
// Related Topics 数组 桶排序 有序集合 排序 滑动窗口 👍 16 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.TreeSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        // 桶
        Map<Integer, Integer> buckets = new HashMap<>();
        int bucketSize = t+1;
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            int id = getBucketID(num, bucketSize);
            if (buckets.containsKey(id) ||
                    (buckets.containsKey(id-1) && buckets.get(id-1)+t>=num) ||
                    (buckets.containsKey(id+1) && buckets.get(id+1)-t<=num)){
                return true;
            }
            buckets.put(id, num);
            if (i >= k){
                buckets.remove(getBucketID(nums[i-k], bucketSize));
            }
        }
        return false;

//        // 滑动窗口+TreeSet
//        TreeSet<Long> set = new TreeSet<>();
//        for (int i = 0; i < nums.length; i++){
//            Long lower = set.floor((long)nums[i]);
//            if (lower != null && lower >= (long)nums[i]-t){
//                return true;
//            }
//            Long upper = set.ceiling((long)nums[i]);
//            if (upper != null && upper <= (long)nums[i]+t){
//                return true;
//            }
//            set.add((long)nums[i]);
//            if (i >= k){
//                set.remove((long)nums[i-k]);
//            }
//        }
//        return false;

//        // 暴力法（超时）
//        for (int i = 0; i < nums.length; i++){
//            int j = 0;
//            if (i>=k){
//                j = i-k;
//            }
//            for (; j < i && j >=0; j++){
//                if (Math.abs((long)nums[i]-(long)nums[j]) <= (long)t){
//                    return true;
//                }
//            }
//        }
//        return false;


    }

    private int getBucketID(int num, int bucketSize){
        return num >=0
                ? num / bucketSize
                : (num+1) / bucketSize-1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
