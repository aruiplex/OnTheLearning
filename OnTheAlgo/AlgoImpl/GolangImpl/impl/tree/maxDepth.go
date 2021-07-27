package impl

import "container/list"

/**
 * Definition for a binar tree node.
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxDepth(root *TreeNode) int {
	// // 全局最大深度
	// maxd := 0
	// // 当前最大深度
	// depth := 0
	// stack := []*TreeNode{root}

	// for len(stack) != 0 {
	// 	node := stack[]

	// 	if node.Left != nil {
	// 		stack.Push(node.Left)
	// 		depth++
	// 		maxd = max(maxd, depth)
	// 	} else if node.Right != nil {
	// 		stack.Push(node.Right)
	// 		depth++
	// 		maxd = Max(maxd, depth)
	// 	} else {
	// 		depth--
	// 	}
	// }
	// return maxd
	return 0
}

func Traversal(root *TreeNode) []*TreeNode {
	nodes := []*TreeNode{}
	stack := NewStack()
	stack.Push(root)
	for !stack.Empty() {
		node := stack.Pop().(*TreeNode)
		nodes = append(nodes, node)
		if node.Left != nil {
			stack.Push(node.Left)
		}
		if node.Right != nil {
			stack.Push(node.Right)
		}
	}
	return nodes
}

type Stack struct {
	list *list.List
}

func NewStack() *Stack {
	list := list.New()
	return &Stack{list}
}

func (stack *Stack) Push(value interface{}) {
	stack.list.PushBack(value)
}

func (stack *Stack) Pop() interface{} {
	e := stack.list.Back()
	if e != nil {
		stack.list.Remove(e)
		return e.Value
	}
	return nil
}

func (stack *Stack) Peak() interface{} {
	e := stack.list.Back()
	if e != nil {
		return e.Value
	}

	return nil
}

func (stack *Stack) Len() int {
	return stack.list.Len()
}

func (stack *Stack) Empty() bool {
	return stack.list.Len() == 0
}
