package impl

/*

705. 设计哈希集合
不使用任何内建的哈希表库设计一个哈希集合（HashSet）。

实现 MyHashSet 类：

void add(key) 向哈希集合中插入值 key 。
bool contains(key) 返回哈希集合中是否存在这个值 key 。
void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。

示例：

输入：
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
输出：
[null, null, null, true, false, null, true, null, false]

解释：
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // 返回 True
myHashSet.contains(3); // 返回 False ，（未找到）
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // 返回 True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // 返回 False ，（已移除）


提示：

0 <= key <= 106
最多调用 104 次 add、remove 和 contains 。


进阶：你可以不使用内建的哈希集合库解决此问题吗？

-------------------------------------------------------------------------

题目复述:

自己实现一个 HashSet , 不使用任何自带的 hash 工具.

实现 3 个方法.

看来以下 java 的实现方法, object.hashcode() 是 native 方法...

看了以下leetcode 的官方回答, hash函数的简单形式就是取余了.

index = x % base

base 是当前容器的大小
*/

type MyHashSet struct {
	set [][]int
}

const base = 769

/** Initialize your data structure here. */
func ConstructorSet() MyHashSet {
	return MyHashSet{make([][]int, base)}
}

func (this *MyHashSet) Add(key int) {
	index := hash(key)
	if this.set[index] != nil {
		l := &this.set[index]
		for _, v := range *l {
			if v == key {
				return
			}
		}
	}
	this.set[index] = append(this.set[index], key)
}

func (this *MyHashSet) Remove(key int) {
	index := hash(key)
	l := &this.set[index]
	for i, v := range *l {
		if v == key {
			*l = append((*l)[:i], (*l)[i+1:]...)
			break
		}
	}
}

/** Returns true if this set contains the specified element */
func (this *MyHashSet) Contains(key int) bool {
	index := hash(key)
	l := &this.set[index]
	if *l != nil {
		for _, v := range *l {
			if v == key {
				return true
			}
		}
	}
	return false
}

func hash(key int) int {
	return key % base
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Add(key);
 * obj.Remove(key);
 * param_3 := obj.Contains(key);
 */

/*

执行用时：
112 ms, 在所有 Go 提交中击败了 13.89% 的用户

内存消耗：9.8 MB, 在所有 Go 提交中击败了 22.22% 的用户

*/
