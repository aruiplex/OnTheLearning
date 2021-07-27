package impl

import "fmt"

type LinkedNode struct {
	key, value int
	pre, next  *LinkedNode
}

type LRUCache struct {
	cache map[int]*LinkedNode
	cap   int
	head  *LinkedNode
}

func Constructor(capacity int) LRUCache {
	head := &LinkedNode{0, 0, nil, nil}
	head.next = head
	head.pre = head
	return LRUCache{make(map[int]*LinkedNode), capacity, head}
}

func (this *LRUCache) Get(key int) int {
	v, isExist := this.cache[key]
	if isExist {
		this.MoveToHead(v)
		return v.value
	}
	return -1
}

// RemoveNode 删掉 node
func (this *LRUCache) RemoveNode(node *LinkedNode) {
	node.pre.next = node.next
	node.next.pre = node.pre
}

// AddNode 把 node 放到最前面
func (this *LRUCache) AddNode(node *LinkedNode) {
	node.next = this.head.next
	this.head.next.pre = node
	node.pre = this.head
	this.head.next = node
}

// MoveToHead 把原来位置的 node 删掉, 并放到最前面
func (this *LRUCache) MoveToHead(node *LinkedNode) {
	this.RemoveNode(node)
	this.AddNode(node)
}

func (this *LRUCache) Put(key int, value int) {
	v, isExist := this.cache[key]
	// 如果这个点已经存在了
	if isExist {
		// 更新值
		v.value = value
		// 放到最前面
		this.MoveToHead(v)
	} else {
		v := &LinkedNode{key, value, nil, nil}
		if len(this.cache) == this.cap {
			// cache 中的最后一个删掉
			delete(this.cache, this.head.pre.key)
			// 双向链表中的这个也删掉
			this.RemoveNode(this.head.pre)
		}
		// 在链表中添加 node
		this.AddNode(v)
		// 在 cache 中添加 node
		this.cache[key] = v
	}
}
func (this *LRUCache) ToString() string {
	node := this.head.next
	s := ""
	for node != this.head {
		s += node.ToString()
		node = node.next
	}
	return s
}

// ToString return LinkedNode to string
func (node *LinkedNode) ToString() string {
	return fmt.Sprintf("{%d: %d} ", node.key, node.value)
}

func (this *LRUCache) MapToString() string {
	s := "Cache:"
	for k, v := range this.cache {
		s += fmt.Sprintf(" { %v, %v } ", k, v)
	}
	return s
}

/* main
lRUCache.Put(1, 1) // 缓存是 {1=1}
lRUCache.Put(2, 2) // 缓存是 {1=1, 2=2}
lRUCache.Get(1)    // 返回 1
lRUCache.Put(3, 3) // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.Get(2)    // 返回 -1 (未找到)
lRUCache.Put(4, 4) // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.Get(1)    // 返回 -1 (未找到)
lRUCache.Get(3)    // 返回 3
lRUCache.Get(4)    // 返回 4
*/
