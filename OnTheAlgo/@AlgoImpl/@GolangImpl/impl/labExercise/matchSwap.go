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
