package impl

// EvenAppend lab Exercise
/*

Lab Exercise 2.2 Even Append
Given an input of a list of strings, write a method to build a result string as follows:
when a string appears the 2nd, 4th, 6th, etc. time in the list,
append the string to the result.

Return the empty string if no string appears a 2nd time.

Test case 1:
evenAppend(["a", "b", "a"])  →  "a"

Test case 2:
evenAppend(["a", "b", "b", "a", "a"])  →  "ba"


*/
func EvenAppend(arr []string) string {
	ans := ""
	m := map[string]int{}
	for _, v := range arr {
		_, isExisted := m[v]
		if isExisted {
			delete(m, v)
			ans += string(v)
		} else {
			m[v]++
		}
	}
	return ans
}
