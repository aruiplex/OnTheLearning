package impl

/*

存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。

返回同样按升序排列的结果链表。



示例 1：


输入：head = [1,1,2]
输出：[1,2]
示例 2：


输入：head = [1,1,2,3,3]
输出：[1,2,3]


提示：

链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序排列
通过次数216,100提交次数406,901

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/

/**
 * Definition for singly-linked list.
 */

func deleteDuplicates(head *ListNode) *ListNode {
	// 这个条件太容易忘记了
	if head == nil {
		return nil
	}
	node := head
	// till the end
	for node.Next != nil {
		if node.Val == node.Next.Val {
			node.Next = node.Next.Next
		} else {
			node = node.Next
		}
	}
	return head
}

/*

执行结果：
通过
显示详情
执行用时：
0 ms
, 在所有 Go 提交中击败了
100.00%
的用户
内存消耗：
3.1 MB
, 在所有 Go 提交中击败了
62.66%
的用户


*/
