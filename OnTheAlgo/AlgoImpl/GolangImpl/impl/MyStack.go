package impl

import "container/list"

type MyStack struct {
	mainList   list.List
	bufferList list.List
}

// /** Initialize your data structure here. */
// func Constructor() MyStack {
// 	return MyStack{}
// }

// /** Push element x onto stack. */
// func (this *MyStack) Push(x int) {
// 	this.bufferList.PushBackList(&this.mainList)

// }

// /** Removes the element on top of the stack and returns that element. */
// func (this *MyStack) Pop() int {

// }

// /** Get the top element. */
// func (this *MyStack) Top() int {

// }

// /** Returns whether the stack is empty. */
// func (this *MyStack) Empty() bool {

// }

/**
 * Your MyStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.Empty();
 */
