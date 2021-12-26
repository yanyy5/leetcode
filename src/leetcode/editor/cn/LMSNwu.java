//给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。 
//
// 
//
// 注意：本题与主站 445 题相同：https://leetcode-cn.com/problems/add-two-numbers-ii/ 
// Related Topics 栈 链表 数学 👍 18 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 方法2：栈
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int adds = 0;
        ListNode dummy = new ListNode(0);
        Stack<Integer> res = new Stack<>();
        while (!stack1.isEmpty() || !stack2.isEmpty() || adds != 0){
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = x + y + adds;
            adds = sum / 10;
            sum = sum % 10;
            res.push(sum);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        ListNode result = dummy;
        while (!res.isEmpty()){
            ListNode temp = new ListNode(res.pop());
            result.next = temp;
            result = result.next;
        }
        return dummy.next;

//        // 方法1：翻转链表
//        l1 = reverseListNode(l1);
//        l2 = reverseListNode(l2);
//
//        int adds = 0;
//        ListNode dummy = new ListNode(0);
//        ListNode res = dummy;
//        while (l1 != null || l2 != null || adds != 0){
//            int x = l1 == null ? 0 : l1.val;
//            int y = l2 == null ? 0 : l2.val;
//            int sum = x + y + adds;
//            adds = sum / 10;
//            sum = sum % 10;
//            ListNode temp = new ListNode(sum);
//            res.next = temp;
//            res = res.next;
//            l1 = l1 == null ? null : l1.next;
//            l2 = l2 == null ? null : l2.next;
//        }
//        return reverseListNode(dummy.next);




    }

//    private ListNode reverseListNode(ListNode head){
//
//        ListNode prev = null;
//        ListNode cur = head;
//        while (cur != null){
//            ListNode next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        return prev;
//
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
