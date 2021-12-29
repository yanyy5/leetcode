//给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶: 采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？ 
//
// 
//
// 注意：本题与主站 540 题相同：https://leetcode-cn.com/problems/single-element-in-a-sorted-
//array/ 
// Related Topics 数组 二分查找 👍 10 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNonDuplicate(int[] nums) {

        // 方法2：只找偶数索引
        if (nums.length == 1){
            return nums[0];
        }
        if (nums[0] < nums[1]){
            return nums[0];
        }
        if (nums[nums.length-1] > nums[nums.length-2]){
            return nums[nums.length-1];
        }
        int pointer = 2;
        while (pointer < nums.length){
            if (nums[pointer] > nums[pointer-1] && nums[pointer] < nums[pointer+1]){
                return nums[pointer];
            }
            pointer += 2;
        }
        return -1;


//        // 方法1：二分
//        if (nums.length == 1){
//            return nums[0];
//        }
//        if (nums[0] < nums[1]){
//            return nums[0];
//        }
//        if (nums[nums.length-1] > nums[nums.length-2]){
//            return nums[nums.length-1];
//        }
//
//        int left = 1, right = nums.length-2;
//        while (left <= right){
//            int mid = (left + right) / 2;
//            if (nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]){
//                return nums[mid];
//            }
//            else{
//                if (nums[mid] == nums[mid+1]){
//                    mid++;
//                }
//                if (mid % 2 == 1){
//                    left = mid + 1;
//                }
//                else{
//                    right = mid - 2;
//                }
//            }
//        }
//        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
