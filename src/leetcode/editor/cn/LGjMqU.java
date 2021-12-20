//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/ 
// Related Topics 栈 递归 链表 双指针 👍 21 👎 0

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
    public void reorderList(ListNode head) {

        if (head.next == null){
            return;
        }

        // 把链表分成两半
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null){
                fast = fast.next;
            }
        }

        // 重新拼接
        ListNode temp = slow.next;
        slow.next = null;   // 切断
        reLink(head, reverse(temp), dummy);


    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private void reLink(ListNode l1, ListNode l2, ListNode head){
        ListNode pointer = head;
        while (l1 != null && l2 != null){
            ListNode p1 = l1.next;

            pointer.next = l1;
            l1.next = l2;
            pointer = l2;

            l1 = p1;
            l2 = l2.next;
        }
        if (l1 != null){
            pointer.next = l1;
        }
    }




}
//leetcode submit region end(Prohibit modification and deletion)
