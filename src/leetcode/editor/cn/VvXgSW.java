//给定一个链表数组，每个链表都已经按升序排列。 
//
// 请将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 
//输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// 
//
// 注意：本题与主站 23 题相同： https://leetcode-cn.com/problems/merge-k-sorted-lists/ 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 20 👎 0

package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Comparator;
import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {


        // mergrSort
        if (lists.length == 0){
            return null;
        }
        return mergeList(lists, 0, lists.length);





//        // 最小堆
//        ListNode dummy = new ListNode(0);
//        ListNode cur = dummy;
//        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
//        for (ListNode list : lists){
//            if (list != null){
//                minHeap.offer(list);
//            }
//        }
//        while (!minHeap.isEmpty()){
//            ListNode least = minHeap.poll();
//            cur.next = least;
//            cur = cur.next;
//            if (least.next != null){
//                minHeap.offer(least.next);
//            }
//        }
//        return dummy.next;



//        // 暴力
//        if (lists.length == 0){
//            return null;
//        }
//        if (lists.length == 1){
//            return lists[0];
//        }
//        ListNode head1 = lists[0];
//        for (int i = 1; i<lists.length; i++){
//            ListNode head2 = lists[i];
//            head1 = merge(head1, head2);
//        }
//        return head1;

    }

    private ListNode mergeList(ListNode[] lists, int start, int end){
        if (start+1 >= end){
            return lists[start];
        }
        int mid = (start+end)/2;
        ListNode h1 = mergeList(lists, start, mid);
        ListNode h2 = mergeList(lists, mid, end);
        return merge(h1, h2);
    }

    private ListNode merge(ListNode h1, ListNode h2){
        if (h1 == null){
            return h2;
        }
        if (h2 == null){
            return h1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (h1 != null && h2 != null){
            if (h1.val < h2.val){
                cur.next = h1;
                h1 = h1.next;
            }
            else{
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        cur.next = h1 == null ? h2 : h1;
        return dummy.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
