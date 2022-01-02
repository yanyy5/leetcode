//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 215 题相同： https://leetcode-cn.com/problems/kth-largest-element-in-an-
//array/ 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 17 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {

        return findPivot(nums, 0, nums.length-1, k);

        // quickselect
//        int target = nums.length-k;
//        int start = 0;
//        int end = nums.length-1;
//        int index = partition(nums, start, end);
//        while (index != target){
//            if (index > target){
//                end = index-1;
//            }
//            else{
//                start = index+1;
//            }
//            index = partition(nums, start, end);
//        }
//        return nums[index];


//        // 堆排序
//        Queue<Integer> minHeap = new PriorityQueue<>();
//        for (int i = 0; i < nums.length; i++){
//            if (i < k){
//                minHeap.offer(nums[i]);
//            }
//            else{
//                if (nums[i] > minHeap.peek()){
//                    minHeap.poll();
//                    minHeap.offer(nums[i]);
//                }
//            }
//        }
//        return minHeap.peek();

    }

    private int findPivot(int[] nums, int start, int end, int k){
        int pivot = partition(nums, start, end);
        if (pivot == nums.length-k){
            return nums[pivot];
        }
        else if (pivot < nums.length-k){
            return findPivot(nums, pivot+1, end, k);
        }
        else {
            return findPivot(nums, start, pivot-1, k);
        }
    }

    private int partition(int[] nums, int start, int end){
        int random = new Random().nextInt(end-start+1)+start;
        swap(nums, random, end);

        int small = start-1;
        for(int i = start; i < end; i++){
            if (nums[i] < nums[end]){
                small++;
                swap(nums, small, i);
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }

    private void swap(int[] nums, int index1, int index2){
        if (index1 != index2){
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
