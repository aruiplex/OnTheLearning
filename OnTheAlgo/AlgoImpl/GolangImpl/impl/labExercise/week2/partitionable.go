package impl

/*

Exercise 2.2 Partitionable
We define a list to be partitionable, if there is a place in between two indices in that list where the sum of the numbers on one side is equal to the sum of the numbers on the other side.

Given as an input a non-empty list, write a method that returns true if and only of the list is partitionable.

Test cases:
isPartitionable([1, 1, 1, 2, 1])  →    true
isPartitionable([2, 1, 1, 2, 1])  →   false

一个数组中有一个位置, 能实现这个数组的一侧 == 另一侧

*/

func partitionableNOTWORK(arr []int) bool {
	// left pointer, right pointer
	l, r := 0, len(arr)-1
	// left sum, right sum
	ls, rs := 0, 0

	for l < r && r-l > 1 {
		if ls > rs {
			rs += arr[r]
			r--
			continue
		}
		if ls < rs {
			ls += arr[l]
			l++
			continue
		}
		if ls == rs {
			if len(arr) == 1 {
				return false
			}
			rs += arr[r]
			r--
			ls += arr[l]
			l++
			continue
		}
	}

	return ls == rs
	/*
		这种写法会有点问题, 中间的值不好确定:

		1. 是不是被用了,
		2. 是不是被重复用了

		这让我想到双端队列.

		之后我又觉得这样写没啥问题就是了
	*/
}

/*

觉得这样写非常的自洽, 非常的优雅

*/

func partitionable(arr []int) bool {
	ls, rs := 0, 0
	for len(arr) != 0 {
		if ls > rs {
			rs += len(arr) - 1
			arr = arr[:len(arr)-1]
			continue
		}
		if ls < rs {
			ls += arr[0]
			arr = arr[1:]
			continue
		}
		if ls == rs {
			if len(arr) == 1 {
				return false
			}
			ls += arr[0]
			arr = arr[1:]
			rs += arr[len(arr)-1]
			arr = arr[:len(arr)-1]
			continue
		}
	}
	return ls == rs
}
