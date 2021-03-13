package impl

func maxNum(nums []int) int {

	ans := 0
	if nums[0] == 1 {

	} else {

	}

	for i := 0; i < len(nums)-1; i++ {

		if nums[i] == 1 {
			ans = nums[i] + nums[i+1]
		} else {

		}
	}
	return ans
}
