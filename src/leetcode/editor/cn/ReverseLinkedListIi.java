//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 👍 1105 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right){
            return head;
        }


//        ListNode start = dummy;
//        int count = 0;
//        while (count < left-1){
//            start = start.next;
//        }
//        ListNode prev = start.next;
//        ListNode cur = prev.next;
//        count = 0;
//        while (count < right-left){
//            ListNode next = cur.next;
//            prev.next = cur.next;
//            cur.next = prev;
//            start.next = cur;
//            cur = next;
//            count++;
//        }


        // 方法2：穿针引线
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 0; i < left-1; i++){
            prev = prev.next;
        }
        ListNode cur = prev.next;
        ListNode next;
        for (int i = 0; i < right-left; i++){
            next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;


//        // 方法1：反转部分链表然后拼接
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode start = dummy;
//        ListNode end = dummy;
//        int count = 0;
//        while (count < left-1){
//            start = start.next;
//            count++;
//        }
//        count = 0;
//        while (count < right+1){
//            end = end.next;
//            count++;
//        }
//
//        // reverse
//        ListNode prev = null;
//        ListNode cur = start.next;
//        count = 0;
//        while (count < right-left+1){
//            ListNode next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//            count++;
//        }
//
//        start.next.next = end;
//        start.next = prev;
//
//        return dummy.next;




    }



}
//leetcode submit region end(Prohibit modification and deletion)
