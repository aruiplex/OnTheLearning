package impl

/*

Exercise 2.4 Match Swap
We define that 2 strings match if they are non-empty and their first letters are the same.  Given a list of non-empty strings, return that list modified as follows: if a string matches an earlier string in the list, swap those 2 strings in the list.  After a position in the list has been swapped, it no longer matches anything.

Hint:  Using a map, this can be solved by making just one pass over the list.

Test case 1:
matchSwap(["apple", "avocado"])  →  ["avocado", "apple"]

Test case 2:
matchSwap(["ab", "ac", "ad", "ae", "af"])  →  ["ac", "ab", "ae", "ad", "af"]

Test case 3:
matchSwap(["ap", "bp", "cp", "aq", "cq", "bq"]) → ["aq", "bq", "cq", "ap", "cp", "bp"]

*/

/*流程:

题目要求:
在首字母相同的情况下, 互换两个单词的位置.

我的思路:
按照首字母顺序, 放到一个数组里(list), 数组里存的是一个{单词string, 出现位置}的结构体,
遍历一遍原数组, 在遍历中, 把每一个单词的首字母拿出来看看在 list 中存不存在, 不存在就把这个添加进去,
存在的话, 就把原来的那个单词放在这个位置上, 并且从 list 中删掉.

*/
func matchSwap(arr []string) []string {
	list := [26]wordAndIndex{}
	ans := make([]string, len(arr))
	var empty = wordAndIndex{}
	for i, s := range arr {
		index := s[0] - 97
		if list[index] == empty {
			// [string in arr] index
			m := wordAndIndex{s, i}
			list[index] = m
		} else {
			// ready to exchange
			word := list[index]
			// exchange position
			ans[word.index] = s
			ans[i] = word.word
			list[index] = empty
		}
	}
	// rest words
	for _, v := range list {
		if v != empty {
			ans[v.index] = v.word
		}
	}

	return ans
}

type wordAndIndex struct {
	word  string
	index int
}
