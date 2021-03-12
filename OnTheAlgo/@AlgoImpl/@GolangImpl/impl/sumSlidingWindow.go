package impl

// SumSlidingWindow return sum of window
// 我看错题了。。。。
func SumSlidingWindow(nums []int, k int) []int {
	l := len(nums) - k + 1
	ans := make([]int, l)
	sum := 0
	for i := 0; i < l; i++ {
		if i == 0 {
			for j := 0; j < k; j++ {
				sum += nums[j]
			}
			ans[0] = sum
		} else {
			sum -= nums[i-1]
			sum += nums[i+k-1]
			ans[i] = sum
		}
	}
	return ans
}
