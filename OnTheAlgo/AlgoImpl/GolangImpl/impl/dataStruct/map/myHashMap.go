package impl

/*

706. 设计哈希映射
不使用任何内建的哈希表库设计一个哈希映射（HashMap）。

实现 MyHashMap 类：

MyHashMap() 用空映射初始化对象
void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。


示例：

输入：
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
输出：
[null, null, null, 1, -1, null, 1, null, -1]

解释：
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]


提示：

0 <= key, value <= 106
最多调用 104 次 put、get 和 remove 方法


进阶：你能否不使用内置的 HashMap 库解决此问题？

------------------------------------------------------------------------------------

和昨天的题基本一样,

只不过昨天里面就只有一个值, 今天是一个结构体.

*/

const BASE = 769

type MyHashMap struct {
	m [][]node
}

type node struct {
	key int
	val int
}

/** Initialize your data structure here. */
func ConstructorMyHashMap() MyHashMap {
	return MyHashMap{make([][]node, BASE)}
}

/** value will always be non-negative. */
func (this *MyHashMap) Put(key int, value int) {
	index := hash(key)
	backet := &(this.m[index])
	if *backet != nil {
		for i := 0; i < len(*backet); i++ {
			if (*backet)[i].key == key {
				(*backet)[i].val = value
				return
			}
		}
	}
	*backet = append(*backet, node{key, value})
}

/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
func (this *MyHashMap) Get(key int) int {
	index := hash(key)
	backet := &(this.m[index])
	for _, n := range *backet {
		if n.key == key {
			return n.val
		}
	}
	return -1
}

/** Removes the mapping of the specified value key if this map contains a mapping for the key */
func (this *MyHashMap) Remove(key int) {
	index := hash(key)
	backet := &(this.m[index])
	for i, n := range *backet {
		if n.key == key {
			*backet = append((*backet)[:i], (*backet)[i+1:]...)
		}
	}
}

func hash(key int) int {
	return key % BASE
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Put(key,value);
 * param_2 := obj.Get(key);
 * obj.Remove(key);
 */

/*

执行结果： 通过 显示详情

执行用时： 120 ms, 在所有 Go 提交中击败了 40.00% 的用户

内存消耗： 8.8 MB, 在所有 Go 提交中击败了 36.84% 的用户

*/
