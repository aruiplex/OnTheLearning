package impl

// Intersect 两个数组的交集
func Intersect(nums1 []int, nums2 []int) []int {
	numMap := map[int]int{}
	ans := []int{}
	for _, v := range nums1 {
		numMap[v]++
	}
	for _, v := range nums2 {
		if numMap[v] > 0 {
			ans = append(ans, v)
			numMap[v]--
		}
	}
	return ans
}
