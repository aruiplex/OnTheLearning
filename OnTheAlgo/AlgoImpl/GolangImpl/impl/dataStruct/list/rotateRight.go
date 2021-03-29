package impl

/*

61. 旋转链表
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。



示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]
示例 2：


输入：head = [0,1,2], k = 4
输出：[2,0,1]


提示：

链表中节点的数目在范围 [0, 500] 内
-100 <= Node.val <= 100
0 <= k <= 2 * 109
通过次数136,151提交次数330,354

*/

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil {
		return nil
	}
	// 取得链表长度
	size := 1
	node := head
	for node.Next != nil {
		node = node.Next
		size++
	}
	tail := node
	if size == 1 {
		return head
	}
	// 真实的要旋转的长度
	node = head
	rotateSize := k % size
	for i := 0; i < size-rotateSize-1; i++ {
		node = node.Next
	}
	// 新的头部
	headNew := node.Next
	if headNew == nil {
		headNew = head
	}
	// 旋转
	tail.Next = head
	// 新的尾部
	node.Next = nil
	return headNew
}
