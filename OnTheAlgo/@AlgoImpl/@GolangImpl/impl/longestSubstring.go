package impl

import (
	"fmt"
	"strings"
	"time"

	"aruix.net/code/algo/tools"
)

// LongestSubstring leetcode 395
// todo 超出时间限制
// todo this is n^2 suck
func LongestSubstringSucks(s string, k int) int {
	t := time.Now()
	// max is max window length
	// start is window start position
	// cwd is current window length
	max, cwd := 0, k
	// loop times of s, which means windows increase gradually
	for i := cwd; i <= len(s); i++ {
		// cwd map is char apparence times
		cwdMap := map[string]int{}
		// every time of window silde, which means window position change
		for j := -1; j < len(s)-cwd; j++ {
			// init for the first window
			if j == -1 {
				for y := 0; y < cwd; y++ {
					cwdMap[string(s[y])]++
				}
			} else {
				cwdMap[string(s[j])]--
				cwdMap[string(s[j+cwd])]++
			}
			// is there any element of this cwd not satisfied
			isAnyEleNotSatisfied := false
			// check times from map
			for _, v := range cwdMap {
				if v < k && v != 0 {
					// not meet requirement
					isAnyEleNotSatisfied = true
					break
				}
			}
			if !isAnyEleNotSatisfied {
				max = cwd
			}
		}
		cwd++
	}
	fmt.Println("耗时: ", time.Since(t))
	return max
}

func LongestSubstring(s string, k int) int {
	maxLength := 0
	// base line
	if len(s) < k {
		return 0
	}
	// word frequency map
	sMap := map[string]int{}
	for _, v := range s {
		sMap[string(v)]++
	}

	noUseless := true
	// useless chars set
	uselessMap := map[string]struct{}{}
	for char, times := range sMap {
		if times < k {
			noUseless = false
			// put useless char to char set
			uselessMap[char] = struct{}{}
		}
	}

	// always someone no useless condition
	// because useless is fail situation
	if noUseless {
		return len(s)
	}

	ss := []string{}
	for char := range uselessMap {
		s = strings.Replace(s, char, ";", -1)
	}

	ss = strings.Split(s, ";")

	for _, v := range ss {
		maxLength = tools.Max(LongestSubstring(v, k), maxLength)
	}
	return maxLength
}

func countFuncTime(fn func(a, b int) int, a, b int) {
	t := time.Now()
	fn(a, b)
	fmt.Println(time.Since(t))
}

func fn(a, b int) int {
	return a + b
}
