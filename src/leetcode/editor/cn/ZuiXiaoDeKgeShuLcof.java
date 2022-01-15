//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 346 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {

        if (k == 0){
            return new int[]{};
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < arr.length; i++){
            if (i < k){
                maxHeap.offer(arr[i]);
            }
            else{
                if (arr[i] < maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.offer(arr[i]);
                }
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = maxHeap.poll();
        }

        return result;



    }
}
//leetcode submit region end(Prohibit modification and deletion)
