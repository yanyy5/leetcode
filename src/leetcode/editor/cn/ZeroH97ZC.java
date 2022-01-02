//给定两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
//
// 
//
// 注意：本题与主站 1122 题相同：https://leetcode-cn.com/problems/relative-sort-array/ 
// Related Topics 数组 哈希表 计数排序 排序 👍 14 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        // 计数排序
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr1){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] counts = new int[max-min+1];
        for (int num : arr1){
            counts[num-min]++;
        }

        int i = 0;
        for (int j = 0; j < arr2.length; j++){
            while(counts[arr2[j]-min]>0){
                arr1[i++] = arr2[j];
                counts[arr2[j]-min]--;
            }
        }
        for (int k = 0; k < counts.length; k++){
            while (counts[k] > 0){
                arr1[i++] = k+min;
                counts[k]--;
            }
        }
        return arr1;



    }
}
//leetcode submit region end(Prohibit modification and deletion)
