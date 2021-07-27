package impl

import "aruix.net/code/algo/tools"

// MaxStretch return max string of repeat char
// Advanced OO Programming Lab Exercise2.1
func MaxStretch(arr []int) int {
	// map [element of arr] [apparence index]
	ans := 0
	m := map[int][]int{}
	for i, v := range arr {
		m[v] = append(m[v], i)
	}

	for _, v := range m {
		if len(v) > 1 {
			ans = tools.Max(v[len(v)-1]-v[0], ans)
		}
	}
	return ans + 1
}
