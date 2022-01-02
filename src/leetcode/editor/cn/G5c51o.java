//给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// 
//
// 注意：本题与主站 347 题相同：https://leetcode-cn.com/problems/top-k-frequent-elements/ 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 11 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (priorityQueue.size()<k){
                priorityQueue.offer(entry);
            }
            else if (entry.getValue() > priorityQueue.peek().getValue()){
                priorityQueue.poll();
                priorityQueue.offer(entry);
            }
        }

        int[] result = new int[priorityQueue.size()];
        for (int i = 0; i < result.length && !priorityQueue.isEmpty(); i++){
            result[i] = priorityQueue.poll().getKey();
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
