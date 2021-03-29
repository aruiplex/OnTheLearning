package impl

/*

92. 反转链表 II
给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。


示例 1：


输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
示例 2：

输入：head = [5], left = 1, right = 1
输出：[5]


提示：

链表中节点数目为 n
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n


进阶： 你可以使用一趟扫描完成反转吗？

通过次数134,797提交次数251,383

Definition for singly-linked list.
type ListNode struct {
    Val int
    Next *ListNode
}

---------------------------------------------------------------------------------------

这题不太难, 在理清楚链表这种东西的原理之后.

这题主要是练习链表的 CRUD

*/

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	dummyNode := &ListNode{Val: 0, Next: head}
	pre := dummyNode
	for i := 0; i < left-1; i++ {
		pre = pre.Next
	}
	// 出来之后, pre会刚好停到 left 的左边
	curr := pre.Next
	for i := 0; i < right-left; i++ {
		nxt := curr.Next

	}

	return dummyNode.Next
}
