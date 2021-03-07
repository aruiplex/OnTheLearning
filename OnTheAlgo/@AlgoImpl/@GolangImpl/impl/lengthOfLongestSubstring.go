package impl

import "strings"

// LengthOfLongestSubstring 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。也就是说在字符串里不能有重复字符.
func LengthOfLongestSubstring(s string) int {
	// max length of strin, which is the answer of this question
	maxLength := 0
	// current length of string
	currLength := 0
	// chars were contained by current string
	existChar := map[string]bool{}

	currIndex := 0
	// for _, v := range s {
	for i := 0; i < len(s); i++ {
		v := string(s[i])
		_, isExist := existChar[v]
		if isExist {
			i = currIndex
			currIndex++
			maxLength = max(currLength, maxLength)
			currLength = 0
			existChar = map[string]bool{}
		} else {
			existChar[v] = true
			currLength++
		}
	}
	maxLength = max(currLength, maxLength)
	return maxLength
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func LengthOfLongestSubstringSample(s string) int {
	start, end := 0, 0
	for i := 0; i < len(s); i++ {
		// 找到 s[i] 第一次出现的地方
		index := strings.Index(s[start:i], string(s[i]))
		// 找没找到
		if index == -1 {
			if i+1 > end {
				end = i + 1
			}
		} else {
			start += index + 1
			end += index + 1
		}
	}
	return end - start
}
