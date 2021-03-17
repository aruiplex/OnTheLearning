package impl

import (
	"strings"

	"aruix.net/code/algo/tools"
)

/*

3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
示例 4:

输入: s = ""
输出: 0


提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成

通过次数 884,326 提交次数 2,411,039

---------------------------------------------------------------

滑动窗口

*/

// 这种解法不行, 双 5%
func LengthOfLongestSubstringSucks(s string) int {
	// max length of string, which is the answer of this question
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
			maxLength = tools.Max(currLength, maxLength)
			currLength = 0
			existChar = map[string]bool{}
		} else {
			existChar[v] = true
			currLength++
		}
	}
	maxLength = tools.Max(currLength, maxLength)
	return maxLength
}

func LengthOfLongestSubstringSample(s string) int {
	start, end := 0, 0
	for i := 0; i < len(s); i++ {
		// 找到 s[i] 第一次出现的地方 这里用到了 strings , 我不大喜欢
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

// LengthOfLongestSubstring 返回最长不重复子字符串
// 这是学了一下写出来的:
// reference: https://www.geekxh.com/1.5.%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E7%B3%BB%E5%88%97/502.html#_03%E3%80%81%E9%A2%98%E8%A7%A3%E5%88%86%E6%9E%90
func LengthOfLongestSubstring(s string) int {
	// 256 位长的
	m := [128]int{}
	w := 0
	for l, r := 0, 0; r < len(s); r++ {
		c := s[r]
		l = tools.Max(m[c], l)
		w = tools.Max(w, r-l+1)
		m[c] = r + 1
	}
	return w
}
