package impl

func findMin(nums []int) int {
	l, r := 0, len(nums)-1
	m := 0
	// 两种特殊情况
	if len(nums) == 1 || nums[l] < nums[r] {
		return nums[0]
	}
	for l < r {
		m = (r + l) / 2
		// 正常情况
		if nums[m] > nums[l] {
			l = m
		} else {
			r = m
		}
	}
	return nums[m+1]
}
